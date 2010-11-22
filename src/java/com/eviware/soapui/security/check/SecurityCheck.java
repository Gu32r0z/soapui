/*
 *  soapUI, copyright (C) 2004-2009 eviware.com 
 *
 *  soapUI is free software; you can redistribute it and/or modify it under the 
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  soapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */
package com.eviware.soapui.security.check;

import javax.swing.JComponent;

import com.eviware.soapui.config.SecurityCheckConfig;
import com.eviware.soapui.impl.wsdl.AbstractWsdlModelItem;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestRunContext;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.security.log.SecurityTestLogModel;

/**
 * SecurityCheck
 * 
 * @author soapUI team
 */
public abstract class SecurityCheck extends AbstractWsdlModelItem<SecurityCheckConfig>
{
	protected SecurityCheck( SecurityCheckConfig config, ModelItem parent, String icon )
	{
		super( config, parent, icon );
	}


	public abstract SecurityCheckConfig getConfig();

	/**
	 * Runs the test (internaly calls analyze) 
	 * 
	 * @param testStep The TestStep that the check will be applied to 
	 * @param context The context to run the test in
	 * @param securityTestLog The security log to write to
	 */
	public abstract void run( TestStep testStep, WsdlTestRunContext context, SecurityTestLogModel securityTestLog );

	
	/**
	 * Analyses the specified TestStep
	 * 
	 * @param testStep
	 * @param context
	 * @param securityTestLog
	 */
	public abstract void analyze( TestStep testStep, WsdlTestRunContext context, SecurityTestLogModel securityTestLog );

	/**
	 * Checks if this securityCheck is applicable to the specified TestStep
	 * 
	 * @param testStep
	 * @return
	 */
	public abstract boolean acceptsTestStep( TestStep testStep );

	/**
	 * Checks if the test is disabled
	 * @return true if disabled
	 */
	public abstract boolean isDisabled();

	/**
	 * Disables or Enables the check
	 * @param disabled
	 */
	public abstract void setDisabled( boolean disabled );

	/**
	 * Gets desktop configuration for specific SecurityCheck
	 * 
	 * @return
	 */
	public abstract JComponent getComponent();

	/**
	 * The type of this check
	 * 
	 * @return
	 */
	public abstract String getType();

}
