package benchmarkCovertToMdrp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;



public class Convert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathStr = "C:\\Users\\A\\Desktop\\";
		String readPath = pathStr + "pdp_100\\lc102.txt";
		String ordersPath = pathStr + "pdp100\\lc102\\orders.txt";
		String restsPath = pathStr + "pdp100\\lc102\\restaurants.txt";
		Reader reader = new Reader();
		reader.read(readPath, ordersPath, restsPath);
		System.out.println("转换已完成！");
	}
	
	

}
