package com.acmecorp.trader.domain;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class stockGeneratorTest {

	@Test
	public void stockGeneratorTest () {
		
		SimpleDateFormat dateConvert = new SimpleDateFormat("mm/dd/yyyy");
		String dateString = "06/30/2018";
		String stockName = "AAPL";
		int days = 7;
		int genID = 1;
		Path filePath = Paths.get("/home/java/java_courses/fidelity-workshop/trader/" + stockName + ".csv");
		
		try {
		Date startDate = dateConvert.parse(dateString);
		assertTrue(stockGenerator.generateStocks(startDate, days, stockName, genID));
		
		Stream<String> fileData = ReadStockFile.readStocks("AAPL");
		} catch (Exception e) {
			e.printStackTrace();
			}
		
		/*
		try {
		Files.delete(filePath);
		} catch (IOException e ) {
			e.printStackTrace();
			}
		*/
		
	}
	
	
}
