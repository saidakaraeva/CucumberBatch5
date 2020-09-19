package Utilities;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelTest {

    public static void main(String[] args) {
     /*   File file=new File("/Users/saidakaraeva/Downloads/CucumberBatch5/src/test/resources/Data/TestCases1.xlsx");
        try {
            FileInputStream input=new FileInputStream(file);
                Workbook workbook=new XSSFWorkbook(input);
                Sheet excelSHeet=workbook.getSheet("Sheet1");
                String value=excelSHeet.getRow(0).getCell(0).toString();
            System.out.println(value);

            Row row=excelSHeet.getRow(1);
            for(int i =0;i<5;i++){
                System.out.println(row.getCell(i).toString());
            }
            Row row1=excelSHeet.getRow(1);
            Cell cell1=row1.createCell(6);
            cell1.setCellType(CellType.STRING);
            cell1.setCellValue("PASS");

FileOutputStream fileOutputStreamm=new FileOutputStream("/Users/saidakaraeva/Downloads/CucumberBatch5/src/test/resources/Data/TestCases1.xlsx");
workbook.write(fileOutputStreamm);

        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        ExcellUtils.openExcelFile("TestCases1","Sheet1");
       String expectedResult= ExcellUtils.getValue(1,4);
        System.out.println(expectedResult);


        ExcellUtils.setValue(1,1,"TEC-2011");

       // List<String>

    }
}
