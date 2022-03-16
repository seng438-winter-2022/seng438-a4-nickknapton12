package org.jfree.data;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range; 
import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class RangeTest {
    
    
    @RunWith(Parameterized.class)
    public static class RangeContainsTest{
    	
    	
    	private Range exampleRange;
    	private Range exampleRange2;
    	private double number;
        private boolean expectedResult;
        private boolean expectedResult2;
        
        public RangeContainsTest(double num, boolean res, boolean res2) {
        	this.number = num;
        	this.expectedResult = res;
        	this.expectedResult2 = res2;
        }
        
        @Before
        public void setUp() throws Exception { 
        	exampleRange2 = new Range(0, 1);
        	exampleRange = new Range(-1, 1);
        }
    		    
	    @Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		{-1.0001, false, false},
	    		{-1, true, false},
	    		{-0.9999,true, false},
	    		{0,true, true},
	    		{0.9999,true, true},
	    		{1,true, true},
	    		{1.0001,false, false},
	    		{1.000,true, true},
	    	});
	    }
	    
	    @Test
	    public void containsTest() {
	    	assertEquals("Contains test", this.expectedResult,exampleRange.contains(this.number));
	    }
	    
	    @Test
	    public void containsTest2() {
	    	assertEquals("Contains test", this.expectedResult2, exampleRange2.contains(this.number));
	    }
	    
	    @After
        public void tearDown() throws Exception {
	    	exampleRange = null;
        	assertNull(exampleRange);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class RangeCombinedTest{
    	
    	
    	private Range firstRange;
    	private Range secondRange;
    	private Range expectedRange;
        
        public RangeCombinedTest(Range first, Range second, Range expected) {
        	this.firstRange = first;
        	this.secondRange = second;
        	this.expectedRange = expected;
        }
        
        @Before
        public void setUp() throws Exception { 
        }
        
	    
	    @Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		{new Range(0,2), new Range(1,2), new Range(0,2)},
	    		{new Range(1,2), new Range(0,2), new Range(0,2)},
	    		{new Range(0,2), new Range(0,1), new Range(0,2)},
	    		{new Range(0,1), new Range(0,2), new Range(0,2)},
	    		{new Range(0,2), new Range(2,4), new Range(0,4)},
	    		{new Range(0,1), new Range(3,4), new Range(0,4)},
	    		{new Range(-1,0), new Range(0,1), new Range(-1,1)},
	    		{new Range(0,1), new Range(0,1), new Range(0,1)},
	    		{new Range(0,1), null, new Range(0,1)},
	    		{null, new Range(0,1), new Range(0,1)},
	    		{null, null, null},
	    		{new Range(0,0), new Range(0,0), new Range(0,0)},
	    		{new Range(0,50000), new Range(-50000,0), new Range(-50000,50000)},
	    		
	    		
	    	});
	    }
	    
	    @Test
	    public void combineTest() {
	    	assertEquals("Combine test", this.expectedRange, Range.combine(firstRange, secondRange));
	    }
	    
	    @After
        public void tearDown() throws Exception {
        	firstRange = null;
        	secondRange = null;
        	expectedRange = null;
        	assertNull(firstRange);
        	assertNull(secondRange);
        	assertNull(expectedRange);
        	
        }

    }
    
    @RunWith(Parameterized.class)
    public static class RangeIntersectsDoubleTest{
    	
    	
    	private double b0, b1;
    	private Range range1;
    	private boolean expected;
        
        public RangeIntersectsDoubleTest(double first, double second, Range r1, boolean expected) {
        	this.b0 = first;
        	this.b1 = second;
        	this.range1 = r1;
        	this.expected = expected;
        }
        
        @Before
        public void setUp() throws Exception { 
        }
        
	    
	    @Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		{0, 10, new Range(5,15), true},
	    		{0, 10, new Range(-5,5), true},
	    		{0, 10, new Range(11, 20), false},
	    		{0, 10, new Range(-10, -1), false},
	    		{0,10, new Range(-10,0), false},
	    		{0,10, new Range(10, 14), false},
	    		{-1,0 , new Range(-1, -1), true},
	    		{0,1 , new Range(0, 2), true},
	    		{0,-1 , new Range(1, 2), false},
	    		{0,0 , new Range(0, 0), false},
	    		{0,2 , new Range(-1, 1), true},
	    		{0,2 , new Range(-1, 0), false},
	    		{0,-1 , new Range(-1, 1), false},
	    		{0,0 , new Range(-1, 1), true},
	    	});
	    }
	    
	    @Test
	    public void intersectsTestDoubles() {
	    	assertEquals("Range intersects Double test", range1.intersects(this.b0, this.b1), this.expected);
	    }
	    
	    @After
        public void tearDown() throws Exception {
        	range1 = null;

        	assertNull(range1);
        	
        }

    }
    
    @RunWith(Parameterized.class)
    public static class RangeIntersectsRangeTest{
    	
    	
    	private Range b0, b1;
    	private boolean expected;
        
        public RangeIntersectsRangeTest(Range first, Range second, boolean expected) {
        	this.b0 = first;
        	this.b1 = second;
        	this.expected = expected;
        }
        
        @Before
        public void setUp() throws Exception { 
        }
        
	    
	    @Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		{new Range(0, 10), new Range(5,15), true},
	    		{new Range(0, 10), new Range(-5,5), true},
	    		{new Range(0, 10), new Range(11, 20), false},
	    		{new Range(0, 10), new Range(-10, -1), false},
	    		{new Range(0,10), new Range(-10,0), false},
	    		{new Range(0,10), new Range(10, 14), false},
	    	});
	    }
	    
	    @Test
	    public void intersectsTestDoubles() {
	    	assertEquals("Range intersects Range Test", b0.intersects(this.b1), this.expected);
	    }
	    
	    @After
        public void tearDown() throws Exception {
        	b0 = null;
        	b1 = null;
        	
        	assertNull(b0);
        	assertNull(b1);
        	
        }

    }
    
    @RunWith(Parameterized.class)
    public static class RangeCombineIgnoringNaNTests{
    	
    	
    	private Range b0, b1;
    	private Range expected;
        
        public RangeCombineIgnoringNaNTests(Range first, Range second, Range expected) {
        	this.b0 = first;
        	this.b1 = second;
        	this.expected = expected;
        }
        
        @Before
        public void setUp() throws Exception { 
        }
        
	    
	    @Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		{null, null, null},
	    		{null, new Range(-5,5), new Range(-5,5)},
	    		{null, new Range(Double.NaN, Double.NaN), null},
	    		{new Range(Double.NaN, Double.NaN), null, null},
	    		{new Range(0,10), null, new Range(0,10)},
	    		{new Range(0,10), new Range(10, 14), new Range(0,14)},
	    		{new Range(Double.NaN, Double.NaN), new Range(Double.NaN, Double.NaN), null},
	    		{new Range(Double.NaN,50000), new Range(-50000,0), new Range(-50000,50000)},
	    		{new Range(-1,50000), new Range(Double.NaN,0), new Range(-1,50000)},
	    		{new Range(0,Double.NaN), new Range(-50000,10), new Range(-50000,10)},
	    		{new Range(0,10), new Range(-50000,Double.NaN), new Range(-50000,10)},
	    	});
	    }
	    
	    @Test
	    public void intersectsTestDoubles() {
	    	assertEquals("Range combineIgnoringNaN Test", Range.combineIgnoringNaN(this.b0, this.b1), this.expected);
	    }
	    
	    @After
        public void tearDown() throws Exception {
        	b0 = null;
        	b1 = null;
        	expected = null;
        	
        	assertNull(b0);
        	assertNull(expected);
        	assertNull(b1);
        	
        }

    }
    
    public static class RangeRegularTests{
    	private Range exampleRange;
    	private Range NANRange;
    	private Range secondNaNRange;
    	private Range firstNaNRange;
    	private Range secondRange;
        

        @BeforeClass public static void setUpBeforeClass() throws Exception {
        }


        @Before
        public void setUp() throws Exception { 
        	exampleRange = new Range(-1, 1);
        	NANRange = new Range(Double.NaN,Double.NaN);
        	secondNaNRange = new Range(-1, Double.NaN);
        	firstNaNRange = new Range(Double.NaN, 1);
        	secondRange = new Range(2,4);
        }


        @Test
        public void centralValueShouldBeZero() {
            assertEquals("The central value of -1 and 1 should be 0",
            0, exampleRange.getCentralValue(), .000000001d);
        }
        
        @Test
        public void centralValueShouldBe3() {
            assertEquals("The central value of 2 and 4 should be 0",
            3, secondRange.getCentralValue(), .000000001d);
        }
        
        @Test
        public void correctUpperBound() {
        	assertEquals("The Upper Bound should be 1",1,exampleRange.getUpperBound(),.000000001d);
        }
        
        @Test
        public void correctLowerBound() {
        	assertEquals("The Lower Bound should be -1",-1,exampleRange.getLowerBound(),.000000001d);
        }
        
        @Test
        public void correctLength() {
        	assertEquals("The length should be 2", 2, exampleRange.getLength(),.000000001d);
        }
        
        @Test
        public void correctString(){
        	assertEquals("The string should be \"Range[-1,1]\"", "Range[-1.0,1.0]" ,exampleRange.toString());
        }
        
        @Test
        public void isNaNRangeTestNaN() {
        	assertTrue("The Range is NaN so should be true.",NANRange.isNaNRange());
        }
        
        @Test
        public void isNaNRangeTestDouble() {
        	assertFalse("The Range is a double so should be false.",exampleRange.isNaNRange());
        }
        
        @Test
        public void isNaNRangeTestNaNSecondArg() {
        	assertFalse("The Range is a double so should be false.",secondNaNRange.isNaNRange());
        }
        
        @Test
        public void isNaNRangeTestNaNFirstArg() {
        	assertFalse("The Range is a double so should be false.",firstNaNRange.isNaNRange());
        }
        
        @Test
        public void hashCodeTest() {
        	assertNotEquals(exampleRange.hashCode(), null);
        }
        
        @Test
        public void equalsTestNotRangeType() {
        	assertFalse(exampleRange.equals(null));
        }
        
        @Test
        public void equalsTestLowerBoundNotEqual() {
        	assertFalse(exampleRange.equals(firstNaNRange));
        }
        
        @Test
        public void equalsTestUpperBoundNotEqual() {
        	assertFalse(exampleRange.equals(secondNaNRange));
        }
        
        @Test
        public void constrainTestInBetween() {
        	assertEquals("The value should be 0 as its inbetween", 0, exampleRange.constrain(0), .000000001d);
        }
        
        @Test
        public void constrainTestAbove() {
        	assertEquals("The value should be 0 as its above", 1, exampleRange.constrain(3), .000000001d);
        }
        
        @Test
        public void constrainTestInBelow() {
        	assertEquals("The value should be -1 as its below", -1, exampleRange.constrain(-3), .000000001d);
        }
        
        @Test
        public void constrainTestTopBoundary() {
        	assertEquals("The value should be -1 as its below", 1, exampleRange.constrain(1), .000000001d);
        }
        
        @Test
        public void constrainTestBottomBoundary() {
        	assertEquals("The value should be -1 as its below", -1, exampleRange.constrain(-1), .000000001d);
        }
        
        @Test(expected = IllegalArgumentException.class)
        public void RangeConstructorTestLowerGreaterThanUpper() {
        	Range a = new Range(10, 0);
        }
        
        @Test
        public void shiftTestByOneZeroValid() {
        	assertEquals(new Range(0,2), Range.shift(exampleRange, 1, true));
        }
        
        @Test
        public void shiftTestByOneValid2() {
        	assertEquals(new Range(0,2), Range.shift(new Range(-0.5,1), 1, false));
        }
        
        @Test
        public void shiftTestByTrueZeroInvalid() {
        	assertEquals(new Range(0,2), Range.shift(exampleRange, 1, false));
        }
        
        @Test
        public void shiftTestByNegativeZeroValid() {
        	assertEquals(new Range(-2,0), Range.shift(exampleRange, -1, false));
        }
        
        @Test
        public void shiftTestByNegativeValid() {
        	assertEquals(new Range(-2.5,0), Range.shift(exampleRange, -1.5, false));
        }
        
        @Test
        public void shiftTestByZeroZeroValid() {
        	assertEquals(new Range(1,6), Range.shift(new Range(0,5), 1, false));
        }
        
        @Test(expected = IllegalArgumentException.class)
        public void shiftTestByNull() {
        	Range.shift(null, 1, false);
        }
        
        @Test
        public void shiftTestZeroValid() {
        	assertEquals(new Range(0,2), Range.shift(exampleRange, 1));
        }
        
        
        @Test
        public void expandTestValid() {
        	assertEquals(new Range(-3,3), Range.expand(exampleRange, 1, 1));
        }
        
        @Test
        public void expandTestValid2() {
        	assertEquals(new Range(-5,5), Range.expand(exampleRange, 2, 2));
        }
        
        @Test
        public void expandTestLowerGreaterThenUpper() {
        	assertEquals(new Range(0,0), Range.expand(exampleRange,-1, -1));
        }
        
        @Test(expected = IllegalArgumentException.class)
        public void expandTestNull() {
        	Range.expand(null,-1, -1);
        }
        
        @Test
        public void expandToIncludeTestNull() {
        	assertEquals(new Range(1,1), Range.expandToInclude(null, 1));
        }
        
        @Test
        public void expandToIncludeTestOverRange() {
        	assertEquals(new Range(-1,3), Range.expandToInclude(exampleRange, 3));
        }
        
        @Test
        public void expandToIncludeTestUnderRange() {
        	assertEquals(new Range(-3,1), Range.expandToInclude(exampleRange, -3));
        }
        
        @Test
        public void expandToIncludeTestInRange() {
        	assertEquals(new Range(-1,1), Range.expandToInclude(exampleRange, 0));
        }
        
        @Test(expected = IllegalArgumentException.class)
        public void scaleTestFactorNegative() {
        	Range.scale(exampleRange, -1);
        }
        
        @Test(expected = IllegalArgumentException.class)
        public void scaleTestFactorNegative2() {
        	Range.scale(exampleRange, -0.5);
        }
        
        @Test(expected = IllegalArgumentException.class)
        public void scaleTestnull() {
        	Range.scale(null, 1);
        }
        
        @Test
        public void scaleTestValid() {
        	assertEquals(new Range(-2,2), Range.scale(exampleRange, 2));
        }
        
        @Test
        public void scaleTestValid2() {
        	assertEquals(new Range(-0.5,0.5), Range.scale(exampleRange, 0.5));
        }
        
        @Test
        public void constructorTestInvalidInput() {
        	try {
        		Range a = new Range(1,0);
        	}
        	catch(IllegalArgumentException e) {
        		assertEquals("Range(double, double): require lower (1.0) <= upper (0.0).", e.getMessage());
        		return;
        	}
        	fail("Did not throw error");
        }
        
       
        @After
        public void tearDown() throws Exception {
        	exampleRange = null;
        	assertNull(exampleRange);
        }

        @AfterClass
        public static void tearDownAfterClass() throws Exception {
        }
    }
        
}
