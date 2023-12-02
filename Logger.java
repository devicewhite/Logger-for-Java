/*
 * Copyright(C) 2023 DeviceBlack
 *
 * Licensed under the Apache License, Version 2.0(the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	 http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.devicewhite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.io.IOException;

/**
 * Logger class for writing log messages to a file in the "Logs" directory on external storage.
 */
public class Logger {

	private final File logDir;

	/**
	 * Constructor for Logger.
	 *
	 * @param dir The directory where log files will be stored
	 */
	public Logger(File dir) {
		logDir = dir;
		if (!dir.exists()) dir.mkdirs();
	}

	/**
	 * Logs a message to a file in the "Logs" directory on external storage.
	 *
	 * @param filename The name of the log file
	 * @param text	 The text to be logged
	 */
	public void write(String filename, String text) {
		try {
			// Check file extension
			if (!filename.endsWith(".txt")) filename += ".txt";

			// Create or open the log file
			File logFile = new File(logDir, filename);
			if (!logFile.exists()) logFile.createNewFile();

			// Write the log entry
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			try {
				fw = new FileWriter(logFile, true);
				bw = new BufferedWriter(fw);
		  		
				// Get the current date and time in the Brazilian time zone
				Calendar brazilianCalendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss", Locale.getDefault());
				String realTime = dateFormat.format(brazilianCalendar.getTime());

				// Format and write the log entry
				bw.write(String.format("[ %s ]: %s\n", realTime, text));
			} finally {
				bw.close();
				fw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

