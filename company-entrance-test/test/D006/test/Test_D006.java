package D006.test;

import helper.StandardInputSnatcher;
import helper.StandardOutputSnatcher;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_D006 {

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

		in.inputln("54 km");

		Main.main(null);
		Assert.assertThat(out.readLine(), Is.is("54000000"));
		Assert.assertEquals(out.readLine(), null);
	}

	@Test
	public void “ü—Í—á‚Q() {

		in.inputln("2 cm");

		Main.main(null);
		Assert.assertThat(out.readLine(), Is.is("20"));
		Assert.assertEquals(out.readLine(), null);
	}

	@Test
	public void “ü—Í—á‚R() {

		in.inputln("12 m");

		Main.main(null);
		Assert.assertThat(out.readLine(), Is.is("12000"));
		Assert.assertEquals(out.readLine(), null);
	}
}
