package model;

public class OrderLogic {
	public void execute(Order order) {
		String[] names=order.getNames();//{"まぐろ","サーモン","エビ","タコ","イカ","いくら"};
		String[] counts=order.getCounts();//{"6","1","2","0","1","3"}
		int countsTotal=0;
		String msg="";
		for(int i=0;i<names.length;i++) {
			int count=Integer.parseInt(counts[i]);
			if(count > 0) {
				countsTotal+=count;
				msg+=String.format("%sが%d皿", names[i],count);
			}
		}
		//orderインスタンスに情報をセットする
		order.setTotalCount(countsTotal);
		order.setTotalFee(countsTotal * 100);
		order.setMsg(msg);
	}
}