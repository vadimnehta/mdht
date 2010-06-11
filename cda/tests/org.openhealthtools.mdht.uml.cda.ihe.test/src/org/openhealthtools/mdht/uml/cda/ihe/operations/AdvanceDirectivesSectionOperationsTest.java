/**
 * Copyright (c) 2010 IBM Corporation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *
 * $Id$
 */
package org.openhealthtools.mdht.uml.cda.ihe.operations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EObject;
import org.openhealthtools.mdht.uml.cda.ihe.AdvanceDirectivesSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

/**
 * This class is a JUnit4 test case.
 */
@SuppressWarnings("nls")
public class AdvanceDirectivesSectionOperationsTest
		extends
		org.openhealthtools.mdht.uml.cda.ccd.operations.AdvanceDirectivesSectionOperationsTest {

	protected static final String ADVANCE_DIRECTIVES_SECTION_TEMPLATE_ID = "1.3.6.1.4.1.19376.1.5.3.1.3.34";

	private static final CDATestCase TEST_CASE_ARRAY[] = {
	// Template ID
	// -------------------------------------------------------------
	new TemplateIDCCDValidationTest(ADVANCE_DIRECTIVES_SECTION_TEMPLATE_ID) {

		@Override
		protected boolean validate(final EObject eObjectToTest,
				final BasicDiagnostic diagnostician,
				final Map<Object, Object> map) {
			return AdvanceDirectivesSectionOperations
					.validateIHEAdvanceDirectivesSectionTemplateId(
							(AdvanceDirectivesSection) eObjectToTest,
							diagnostician, map);
		}

	}

	}; // TEST_CASE_ARRAY

	@Override
	protected List<CDATestCase> getTestCases() {
		// Return a new List because the one returned by Arrays.asList is
		// unmodifiable so a sub-class can't append their test cases.
		final List<CDATestCase> retValue = super.getTestCases();
		retValue.addAll(Arrays.asList(TEST_CASE_ARRAY));
		return retValue;
	}

	@Override
	protected EObject getEObjectToValidate() {
		return IHEFactory.eINSTANCE.createAdvanceDirectivesSection();
	}

	@Override
	protected EObject getEObjectInitToValidate() {
		return IHEFactory.eINSTANCE.createAdvanceDirectivesSection().init();
	}

} // AdvanceDirectivesSectionOperationsTest