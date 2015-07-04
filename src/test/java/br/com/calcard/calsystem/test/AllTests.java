package br.com.calcard.calsystem.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.calcard.calsystem.service.test.ServiceTests;

@RunWith(Suite.class)
@SuiteClasses({ ServiceTests.class })
public class AllTests {

}
