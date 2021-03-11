import java.util.TreeSet;
class TreeSetDemo
{
	public static void main(String[] args) {
		TreeSet set= new TreeSet();
		set.add(45);
		set.add(-9);
		
		if(set.add(8))
		{
           System.out.println("already exists");
		}
		System.out.println(set);
		for(Object ref:set)
		{
            System.out.println(ref);
		}
	}
}