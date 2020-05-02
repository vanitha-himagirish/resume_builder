package coreservlets;

import static org.junit.Assert.*;

import org.junit.*;

// This uses JUnit to do the testing, but if you don't know about JUnit, you can
// make a "main" that does some simple test cases. However, if you do Java for
// your "real" work, you should learn the basics of JUnit eventually.

public class StateAbbreviationTester {
  @Test
  public void testStatePair() {
    String stateName = "New York";
    String stateAbbreviation = "NY";
    StatePair pair = new StatePair(stateName, stateAbbreviation);
    assertEquals(stateName, pair.getStateName());
    assertEquals(stateAbbreviation, pair.getStateAbbreviation());
    StateAbbreviationService mapper = new StateAbbreviationMapper();
    assertEquals(mapper.findAbbreviation(stateName), stateAbbreviation);
    assertNull(mapper.findAbbreviation("Ontario"));
  }
}
