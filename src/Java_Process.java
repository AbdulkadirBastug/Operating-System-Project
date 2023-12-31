package packet;

public class Java_Process {


	//Her proses için bu program çalıştırılır.
	public static void main(String[] args) {
		if (args.length >= 4) {
            System.out.println("(id:" + args[0] + "  oncelik:" + args[1] + "  kalan sure:" + args[2] + " sn" + "  MBytes:"+args[3] + " MB"+ "  prn:"+args[4] + " "+"  scn:"+ args[5] + " "+ "  Modem:"+args[6] + " "+ "  CD:"+args[7] + " )");
        } else {
            System.out.println("Yetersiz argüman. Kullanım: java Java_Process <id> <oncelik> <kalan_sure> <ek_arguman>");
        }
	}
}
