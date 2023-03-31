package model;

import java.io.Serializable;

public class Order implements Serializable{
	private final String[] names={"まぐろ","サーモン","エビ","タコ","イカ","いくら","茶碗蒸し"};
	private String[] counts;//それぞれの個数が入る
	private int totalCount;//合計の皿数
	private int totalFee;//合計金額
	private String msg;//「まぐろが2皿エビが3皿」などの情報が入る
	
	public Order() {
		//new された際に、すしの種類の数だけ"0"を入れる
		this.counts=new String[names.length];
		for(int i=0;i<this.counts.length;i++) {
			this.counts[i]="0";
		}
	}
	public String[] getNames() {
		return names;
	}
	public String[] getCounts() {
		return counts;
	}
	public void setCounts(String[] counts) {
		this.counts = counts;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}