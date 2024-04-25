package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderXML {

    private static final String PROPERTIES_FILE_PATH = "src/main/resources/data.xml";

    public static String getProperty(String key) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.loadFromXML(fis);
            return properties.getProperty(key);
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getProperty("user1"));
    }
}
/*
* Этот код представляет класс PropertiesReaderXML, который используется для чтения свойств из файла XML.

    PROPERTIES_FILE_PATH - это строковая константа, содержащая путь к файлу XML, из которого будут считываться свойства.
    * Файл располагается в директории src/main/resources.

    Метод getProperty(String key) принимает ключ в качестве параметра и возвращает значение свойства, соответствующее этому ключу.

    Внутри метода создается объект класса Properties, который будет содержать свойства из файла.

    Затем создается экземпляр FileInputStream, который используется для чтения данных из файла по указанному пути.

    Метод loadFromXML() загружает свойства из файла XML в объект Properties.

    Далее метод getProperty(key) получает значение свойства по заданному ключу и возвращает его.

    Если возникает исключение типа IOException в процессе чтения файла, программа выводит стек вызовов и возвращает null.

Этот класс предоставляет простой способ чтения свойств из файлов XML в Java.*/