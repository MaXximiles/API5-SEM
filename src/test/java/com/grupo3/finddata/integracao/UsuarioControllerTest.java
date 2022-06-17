package com.grupo3.finddata.integracao;

import java.time.Duration;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
@Transactional
public class UsuarioControllerTest {
	private WebDriver driver;
	private String url = "https://finddata-frontend.herokuapp.com/#/";

	@Test
	public void testeUsuarioIntegracao() {

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");

		driver = new ChromeDriver(options);

		driver.get(url);

		String title = driver.getTitle();
		Assertions.assertEquals("Find Data", title);

		driver.quit();

	}

}
