package main;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

//Map cung cấp một cách hiệu quả để lưu trữ và quản lý dữ liệu dưới dạng các cặp key-value

public class TuDien {
	private Map<String, String> duLieu = new TreeMap<String, String>();
	public String themTu (String tuKhoa, String yNghia) {
		return this.duLieu.put(tuKhoa, yNghia);
	}
	public String xoaTu(String tuKhoa) {
		return this.duLieu.remove(tuKhoa);
	}
	public String traTu(String tuKhoa) {
		String yNghia = this.duLieu.get(tuKhoa); // Lấy ra được cái value của từ khóa
		return yNghia;
	}
	public void inTuKhoa() {
		Set<String> tuKhoa = this.duLieu.keySet();
		Collection<String> yNghia = this.duLieu.values();
		//keySet : Đây là một phương thức của đối tượng Map. 
		//Phương thức này trả về một tập hợp (set) chứa tất cả các khóa (keys) trong duLieu
		System.out.println("Các từ khóa (keys):");
		int index = 0;
		for (String key : tuKhoa) {
			index++;
		    System.out.println(index + ", "+key);
		}

		System.out.println("Các giá trị (values):");
		int indexValue = 0;
		for (String value : yNghia) {
			indexValue++;
		    System.out.println(indexValue+", "+value);
		}
	}
	public int soLuong() {
		return this.duLieu.size();
	}
	public void xoaTatCa() {
		this.duLieu.clear();
	}
	public static void main(String[] args) {
		TuDien tuDien = new TuDien();
		
		int luaChon = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Press any keydown to continue...");
			String next = sc.nextLine();
			if(next == "") {
				continue;
			}
			System.out.println("==========MENU==========");
			System.out.println("Tra từ điển Anh - Việt:\n"
					+ "1. Thêm từ (Từ khóa, Ý nghĩa)\n"
					+ "2. Xóa từ\n"
					+ "3. Tìm ý nghĩa của từ khóa ⇒ Tra từ\n"
					+ "4. In ra danh sách từ khóa\n"
					+ "5. Lấy số lượng từ\n"
					+ "6. Xóa tất cả các từ khóa\n"
					+ "0. Thoát khỏi chương trình\n"
					+ "");
			luaChon = sc.nextInt();
			sc.nextLine();
			if(luaChon == 1) {
				System.out.println("Nhập vào từ khóa: ");
				String tuKhoa = sc.nextLine();
				System.out.println("Nhập vào ý nghĩa: ");
				String yNghia = sc.nextLine();
				tuDien.themTu(tuKhoa, yNghia);
			}
			else if (luaChon == 2 || luaChon == 3 ) {
				System.out.println("Nhập vào từ khóa: ");
				String tuKhoa = sc.nextLine();
				if(luaChon == 2) {
					tuDien.xoaTu(tuKhoa);
				}
				else {
					System.out.println("Ý nghĩa của từ là: "+tuDien.traTu(tuKhoa));
				}
			}
			else if(luaChon == 4) {
				tuDien.inTuKhoa();
			}
			else if (luaChon == 5) {
				System.out.println("Số lượng từ khóa là: " + tuDien.soLuong());
			}
			else if (luaChon == 6) {
				tuDien.xoaTatCa();
				System.out.println("Xóa thành công !!!");
			}
		}while(luaChon != 0);
		System.out.println("Cảm ơn bạn đã sử dụng chương trình");
		
	}
	
}
