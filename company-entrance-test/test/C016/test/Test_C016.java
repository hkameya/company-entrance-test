package C016.test;

import helper.StandardInputSnatcher;
import helper.StandardOutputSnatcher;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_C016 {

	private StandardOutputSnatcher out = new StandardOutputSnatcher();
	private StandardInputSnatcher in = new StandardInputSnatcher();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.setOut(out);
		System.setIn(in);
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
		System.setIn(null);
	}

	@Test
	public void “ü—Í—á‚P() {

		in.inputln("BIOS6");

		Main.main(null);
		Assert.assertThat(out.readLine(), Is.is("B1056"));
		Assert.assertEquals(out.readLine(), null);
	}

	@Test
	public void “ü—Í—á‚Q() {

		in.inputln("ALANTURING");

		Main.main(null);
		Assert.assertThat(out.readLine(), Is.is("4L4NTUR1N6"));
		Assert.assertEquals(out.readLine(), null);
	}

}
