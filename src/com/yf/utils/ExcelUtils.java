package com.yf.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.yf.model.Student;

public class ExcelUtils {

	public static void main(String[] args) {
		try {
			List<Student> students = getData();
			readExcel("test", "sheet 1");
			//createExcel("test", "sheet 1", students);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Student> getData() throws ParseException {
		List<Student> list = new ArrayList<Student>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Student stu1 = new Student("0001", "Jim", "20110705001", "Boy",
				df.parse("1989-03-26"));
		Student stu2 = new Student("0002", "ploy", "20110705002", "Girl",
				df.parse("1989-03-26"));
		Student stu3 = new Student("0003", "Tom", "20110705003", "Boy",
				df.parse("1989-03-26"));
		Student stu4 = new Student("0004", "Hans", "20110705004", "Girl",
				df.parse("1989-03-26"));
		Student stu5 = new Student("0005", "Jones", "20110705005", "Girl",
				df.parse("1989-03-26"));
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
		return list;
	}

	/**
	 * @param fileName
	 * @param sheetName
	 * @param students
	 * @throws Exception
	 * 
	 *  操作Excel 数据
	 */
	@SuppressWarnings("deprecation")
	public static void createExcel(String fileName, String sheetName,
			List<Student> students) throws Exception {
		FileOutputStream fos = new FileOutputStream(fileName + ".xls");
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet(sheetName);
		// 创建一个居中的显示样式
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("编号");
		// 单元格设置居中样式
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("学号");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("性别");
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("出生日期");
		cell.setCellStyle(style);
		int index = 1;
		for (Student student : students) {
			row = sheet.createRow(index++);
			row.createCell(0).setCellValue(student.getId());
			row.createCell(1).setCellValue(student.getName());
			row.createCell(2).setCellValue(student.getNo());
			row.createCell(3).setCellValue(student.getGender());
			row.createCell(4).setCellValue(student.getBirth());
		}
		workbook.write(fos);
		fos.flush();
		workbook.close();
	}

	/**
	 * @param fileName
	 * @param sheetName
	 * @throws Exception
	 * 
	 *    读取 Excel 数据
	 */
	public static void readExcel(String fileName, String sheetName)
			throws Exception {
		FileInputStream fis = new FileInputStream(fileName+".xls");
		Workbook workbook=new HSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		for(Iterator<Row> rowIterator = sheet.rowIterator();rowIterator.hasNext();){
			Row row = rowIterator.next();
			for(Iterator<Cell> cellIterator=row.cellIterator();cellIterator.hasNext();){
				Cell cell = cellIterator.next();
				if(cell.getCellType()==Cell.CELL_TYPE_STRING){
					System.out.println(cell.getStringCellValue());
				}else{
					System.out.println(cell.getDateCellValue());
				}
			}
		}
		workbook.close();
		
	}

}
