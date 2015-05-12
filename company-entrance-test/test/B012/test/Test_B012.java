package B012.test;

import helper.StandardInputSnatcher;
import helper.StandardOutputSnatcher;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_B012 {

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

		in.inputln("1");
		in.inputln("846087729128569X");

		Main.main(null);
		Assert.assertThat(out.readLine(), Is.is("7"));
		Assert.assertEquals(out.readLine(), null);
	}

	@Test
	public void “ü—Í—á‚Q() {

		in.inputln("4");
		in.inputln("628381026148991X");
		in.inputln("511070105176715X");
		in.inputln("273492510450813X");
		in.inputln("670891979616350X");

		Main.main(null);
		Assert.assertThat(out.readLine(), Is.is("5"));
		Assert.assertThat(out.readLine(), Is.is("9"));
		Assert.assertThat(out.readLine(), Is.is("7"));
		Assert.assertThat(out.readLine(), Is.is("2"));
		Assert.assertEquals(out.readLine(), null);
	}

	@Test
	public void “ü—Í—á‚R() {

		in.inputln("5");
		in.inputln("091180422478189X");
		in.inputln("774123801013511X");
		in.inputln("973736969204716X");
		in.inputln("793180803472918X");
		in.inputln("358682935182058X");

		Main.main(null);

		Assert.assertThat(out.readLine(), Is.is("1"));
		Assert.assertThat(out.readLine(), Is.is("4"));
		Assert.assertThat(out.readLine(), Is.is("0"));
		Assert.assertThat(out.readLine(), Is.is("1"));
		Assert.assertThat(out.readLine(), Is.is("2"));
		Assert.assertEquals(out.readLine(), null);
	}
}
