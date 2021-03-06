/*
 * Asqatasun - Automated webpage assessment
 * Copyright (C) 2008-2015  Asqatasun.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: asqatasun AT asqatasun DOT org
 */
package org.asqatasun.rules.rgaa32016;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.asqatasun.entity.audit.ProcessResult;
import org.asqatasun.entity.audit.TestSolution;
import org.asqatasun.rules.keystore.AttributeStore;
import org.asqatasun.rules.rgaa32016.test.Rgaa32016RuleImplementationTestCase;
import org.asqatasun.rules.keystore.HtmlElementStore;
import org.asqatasun.rules.keystore.RemarkMessageStore;

/**
 * Unit test class for the implementation of the rule 11.8.3 of the referential RGAA 3.2016
 *
 * @author jkowalczyk
 */
public class Rgaa32016Rule110803Test extends Rgaa32016RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32016Rule110803Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName("org.asqatasun.rules.rgaa32016.Rgaa32016Rule110803");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32016.Test.11.08.03-2Failed-01");
        addWebResource("Rgaa32016.Test.11.08.03-2Failed-02");
        addWebResource("Rgaa32016.Test.11.08.03-2Failed-03");
        addWebResource("Rgaa32016.Test.11.08.03-3NMI-01");
        addWebResource("Rgaa32016.Test.11.08.03-4NA-01");
        addWebResource("Rgaa32016.Test.11.08.03-4NA-02");
        addWebResource("Rgaa32016.Test.11.08.03-4NA-03");

    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32016.Test.11.08.03-2Failed-01");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_OPTGROUP_LABEL_MSG,
                HtmlElementStore.OPTGROUP_ELEMENT,
                1, 
                new ImmutablePair(AttributeStore.LABEL_ATTR,""));
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32016.Test.11.08.03-2Failed-02");
        checkResultIsFailed(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_OPTGROUP_LABEL_MSG,
                HtmlElementStore.OPTGROUP_ELEMENT,
                1, 
                new ImmutablePair(AttributeStore.LABEL_ATTR,"/--*:;!:;*"));
        
        
        //----------------------------------------------------------------------
        //------------------------------2Failed-03------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32016.Test.11.08.03-2Failed-03");
        checkResultIsFailed(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.FAILED,
                RemarkMessageStore.NOT_PERTINENT_OPTGROUP_LABEL_MSG,
                HtmlElementStore.OPTGROUP_ELEMENT,
                1, 
                new ImmutablePair(AttributeStore.LABEL_ATTR,""));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_OPTGROUP_LABEL_PERTINENCE_MSG,
                HtmlElementStore.OPTGROUP_ELEMENT,
                2, 
                new ImmutablePair(AttributeStore.LABEL_ATTR,"OptGroup2"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32016.Test.11.08.03-3NMI-01");
        checkResultIsPreQualified(processResult, 2, 2);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_OPTGROUP_LABEL_PERTINENCE_MSG,
                HtmlElementStore.OPTGROUP_ELEMENT,
                1,
                new ImmutablePair(AttributeStore.LABEL_ATTR,"OptGroup1"));
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                RemarkMessageStore.CHECK_OPTGROUP_LABEL_PERTINENCE_MSG,
                HtmlElementStore.OPTGROUP_ELEMENT,
                2,
                new ImmutablePair(AttributeStore.LABEL_ATTR,"OptGroup2"));
        
        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32016.Test.11.08.03-4NA-01"));
        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32016.Test.11.08.03-4NA-02"));
        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32016.Test.11.08.03-4NA-03"));

    }

}
