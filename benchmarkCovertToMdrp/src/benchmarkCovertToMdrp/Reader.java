package benchmarkCovertToMdrp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Random;

public class Reader {
	public void writeOrders(String ordersPath, String id, double x, double y,
			double placeTime, String restId, double readyTime) {
		final DecimalFormat myFormatter = new DecimalFormat("###.000");
		FileWriter fw = null;
		try {
		
		//����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
		File f=new File(ordersPath);
		fw = new FileWriter(f, true);
		} catch (IOException e) {
		e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		
		pw.print(id + "\t" + x + "\t" +y + "\t" +placeTime + "\t" +restId + "\t" +readyTime);
		pw.print("\n");
		try {
			fw.flush();
			pw.close();
			fw.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	public void writeRests(String restsPath, String id, double x, double y) {
		final DecimalFormat myFormatter = new DecimalFormat("###.000");
		FileWriter fw = null;
		try {
		
		//����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
		File f=new File(restsPath);
		fw = new FileWriter(f, true);
		} catch (IOException e) {
		e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		
		pw.print(id + "\t" + x + "\t" +y);
		pw.print("\n");
		try {
			fw.flush();
			pw.close();
			fw.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	public void read(String readPath, String ordersPath, String restsPath) {
		try {
			int numVisit = 0;
			//
			double capacity;
			final DecimalFormat myFormatter = new DecimalFormat("###.000");
			
			String id;
			double x;
			double y;
			double demand; 
			double twStart;
			double twEnd;
			double service_time;
			int predecessor;
			int successor;		
			
			FileReader input = new FileReader(readPath);
			BufferedReader br = new BufferedReader(input);
			String str = br.readLine();
			String[] firstLine =str.split("	");
			
			str = br.readLine();
			while(str != null) {
				String[] lines =str.split("	");
				id = lines[0];
				x = 100*Integer.valueOf(lines[1]).intValue();//���굥λm
				y = 100*Integer.valueOf(lines[2]).intValue();
				demand = Integer.valueOf(lines[3]).doubleValue();
				twStart = Integer.valueOf(lines[4]).doubleValue()/10;//ʱ�䴰��ʱ�䵥λ��min
				twEnd = Integer.valueOf(lines[5]).doubleValue()/10;
				//service_time = Integer.valueOf(lines[6]).doubleValue();//����ʱ�䵥λmin
				predecessor = Integer.valueOf(lines[7]).intValue();
				successor = Integer.valueOf(lines[8]).intValue();
				String restId = predecessor + "";
				double placeTime = twStart;
				double min = 1.0;
				double max = 20.0;
				double readyTime = placeTime + min + new Random().nextDouble() * (max - min);
				System.out.println("placeTime:"+placeTime+" readyTime:"+ readyTime);
				//predecessor����0˵���õ�Ϊ�ͻ��㣬writeOrders
				if(predecessor > 0) {
					writeOrders(ordersPath, id, x,  y, placeTime, restId, readyTime);
				}
				if(successor > 0) {//ȡ����
					writeRests(restsPath, id, x, y);
				}
     			
				str = br.readLine();
			}
			
						
			br.close();
			

			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
