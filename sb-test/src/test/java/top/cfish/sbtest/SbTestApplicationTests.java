package top.cfish.sbtest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbTestApplicationTests
{
	public static void sayHello()
	{
		System.out.println("hello world");
	}
	
	@Rule
	public OutputCapture outputCapture = new OutputCapture();
	
	@Test
	public void testSout()
	{
		SbTestApplicationTests.sayHello();
		assertThat(this.outputCapture.toString().contains("hello world")).isTrue();
	}
}
