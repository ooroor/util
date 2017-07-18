// Copyright (C) 2014 barakiroth.net
package net.barakiroth.oorutil;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import org.yaml.snakeyaml.Yaml;

/**
 * General utility for reading structured data input from batch input, typically files.
 */
public class BatchUt {
    //// =======================================================================
    //// BEGIN nested classes and enums
    //// END nested classes and enums
    ////=======================================================================
    ////
    //// S T A T I C
    //// =======================================================================
    //// BEGIN static variables
    ////=======================================================================
    //// BEGIN static public variables
    //// END static public variables
    ////=======================================================================
    //// BEGIN static protected variables
    //// END static protected variables
    ////=======================================================================
    //// BEGIN static package variables
    //// END static package variables
    ////=======================================================================
    //// BEGIN static private variables
    ////
    ////
    //// END static private variables
    ////=======================================================================
    //// END static variables
    ////=======================================================================
    ////
    //// I N S T A N C E
    //// =======================================================================
    //// BEGIN instance variables
    ////=======================================================================
    //// BEGIN instance public variables
    //// END instance public variables
    ////=======================================================================
    //// BEGIN instance protected variables
    //// END instance protected variables
    ////=======================================================================
    //// BEGIN instance package variables
    //// END instance package variables
    ////=======================================================================
    //// BEGIN instance private variables
    //// END instance private variables
    ////=======================================================================
    //// END instance variables
    ////=======================================================================
    //// =======================================================================
    //// BEGIN Constructors
    ////
    /**
     * A do-nothing default constructor.
     */
    public BatchUt() {
    }
    ////
    //// END Constructors
    //// =======================================================================
    //// =======================================================================
    //// BEGIN Methods
    ////
    /**
     * Reads a text file in the classpath as named by 
     * the parameter, 
     * parses it as a yaml file, 
     * and then returns the yaml data as parsed.
     *
     * @param fileName The name of the text file assumed to 
     * contain valid YAML, and assumed to be in the classpath.
     * @return The yaml data as parsed.
     * @throws IOException If unexpected errors uopon the strem handling.
     * @throws URISyntaxException If the parameter <code>fileName</code>
     * cannot be successfully converted to a {@link java.net.URI}.
     */
    public Iterable<Object> parseYamlResource(final String fileName)
            throws IOException, URISyntaxException {

    	final URL url = this.getClass().getClassLoader().getResource(fileName);
    	final File file = new File(url.toURI());
    	final Iterable<Object> yamlData = parseYamlFile(file);

    	return yamlData;
    }

    /**
     * Reads a text file as given by the file name parameter, 
     * parses it as a yaml file, 
     * and then returns the yaml data as parsed.
     *
     * @param fileName The name of the text file assumed to 
     * contain valid YAML, and assumed to be accessible by the 
     * filename parameter.
     * @return The yaml data as parsed.
     * @throws IOException If unexpected errors upon the stream handling.
     */
    public Iterable<Object> parseYamlFile(final String fileName)
            throws IOException {

    	File file = new File(fileName);
    	final Iterable<Object> yamlData = parseYamlFile(file);

        return yamlData;
    }

    /**
     * Reads a text file as given by the file parameter, 
     * parses it as a yaml file, 
     * and then returns the yaml data as parsed.
     * 
     * @param inputFile An instance of {@link File} representing 
     * a text file assumed to 
     * contain valid YAML, and assumed to be accessible by the 
     * file parameter.
     * @return The yaml data as parsed.
     * @throws IOException If unexpected errors upon the stream handling.
     */
    public Iterable<Object> parseYamlFile(final File inputFile)
            throws IOException {

    	final long inputFileLengthLong = inputFile.length();
    	if (inputFileLengthLong > Integer.MAX_VALUE) {
    		throw new IOException("File too big for this purpose");
    	}

    	final int inputFileLength = (int)inputFileLengthLong;
    	final byte[] inputBytes = new byte[inputFileLength];
        final InputStream inputStream = new FileInputStream(inputFile);
        inputStream.read(inputBytes, 0, (int)inputFileLength);
        final Iterable<Object> yamlData = parseYamlBytes(inputBytes);
        inputStream.close();

        return yamlData;
    }

    /**
     * Reads the bytes as given by the file parameter, 
     * parses them as a yaml file, 
     * and then returns the yaml data as parsed.
     *
     * @param bytes The bytes assumed to contain valid YAML. 
     * @return The yaml data as parsed.
     */
    public Iterable<Object> parseYamlBytes(final byte[] bytes) {

    	final InputStream inputStream = new ByteArrayInputStream(bytes);
    	final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        final Yaml yaml = new Yaml();
        final Iterable<Object> yamlData = yaml.loadAll(bufferedReader);

        return yamlData;
    }
    ////
    //// END Methods
    //// =======================================================================
}
/*
Revision history:
$Log:$
*/