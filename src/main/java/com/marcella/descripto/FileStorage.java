package com.marcella.descripto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marcella.descripto.model.Answer;

public final class FileStorage {

	private static final Logger LOG = LoggerFactory.getLogger(FileStorage.class);

	private static final String FILE_PATH = "C:\\Users\\Marce\\Documents\\Workspace\\java\\descripto\\";
	private static final String FILE_NAME = "answer.json";

	private FileStorage() {
		super();
	}
	
	public static void writeFile(Answer obj) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH + FILE_NAME, Charset.forName("UTF-8"), false))) {
			// PARA QUE DECLARAR FORMATAÇÃO?
			// PQ ISSO É FEITO EM UM TRY CATCH?
			if (obj != null) {
				bw.write(obj.toString());
			}
		} catch (IOException ioe) {
			LOG.error("Erro ao manipular arquivo.", ioe);
		}
	}
	
	public static File getFile() {
		return new File(FILE_PATH + FILE_NAME);
	}
}
