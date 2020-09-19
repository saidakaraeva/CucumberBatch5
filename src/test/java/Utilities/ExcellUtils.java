package Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcellUtils {

    /*

    .openExelFile(String filename,String shhetName)->ExcelSheet;
    .getValue(int rowNum,int cellNum);-->
    .setValue(int rowNum,int cellNum,String value);-->void;
    .getRowValues(int rowNum);--> return List<String>;
     */

    private static Workbook workbook;
    private static Sheet sheet;
    private static Row row;
    private static Cell cell;
    private static String path;

    /**
     * This method will read excel file with fileName and sheetName then return Sheet
     * @param fileName
     * @param sheetName
     * @return
     */

    public static Sheet openExcelFile(String fileName, String sheetName) {
path="/Users/saidakaraeva/Downloads/CucumberBatch5/src/test/resources/Data"+fileName+".xlsx";
        File  file=new File(path);
        try {

            FileInputStream input =new FileInputStream(file);
            workbook=new XSSFWorkbook(input);
            sheet=workbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            System.out.println(fileName+" excel file doesn't exist");
        }catch (IOException e){
            System.out.println(e.getMessage());

        }return sheet;

    }
    public static String getValue(int rowNum,int cellNum){
        return sheet.getRow(rowNum).getCell(cellNum).toString();

    }
    public static void setValue(int rowNum,int cellNum,String newValue){
        row=sheet.getRow(rowNum);
        cell=row.getCell(cellNum);
        if(cell==null);


    }

    /**
     * This method will store all value to list from provided rowNum.
     * @param rowNum
     * @return
     */
    public static List<String> getRowValue(int rowNum){
        List<String >values=new ArrayList<>();
        row=sheet.getRow(rowNum);
        for(int i=0;i<row.getFirstCellNum();i++){
            values.set(i,row.getCell(i).toString());
        }
        return values;

     }

}
