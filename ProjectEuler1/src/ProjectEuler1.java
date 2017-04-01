import java.util.ArrayList;
import java.util.Iterator;

public class ProjectEuler1
{
	private static ArrayList<Integer> lista= new ArrayList<>();
	
	public ArrayList<Integer> getLista()
	{
		return lista;
	}
	public void setLista(ArrayList<Integer> lista)
	{
		for (int i = 0; i < 999; i++)
		{
			lista.add(i, i+1);			
		}
	}
	
	
	public static  int findTheSum(ArrayList<Integer> list)
	{
		int multiplySum=0;
		for (Integer iter : list)
		{
			if ((iter%3==0) || (iter%5==0))
			{
				multiplySum+=iter;
			}
			/*if ((iter%15==0))
			{
				multiplySum-=iter;
			}*/
		}
		return multiplySum;
	}
	
	
	public static void main(String[] args)
	{
	
	ProjectEuler1 pe = new ProjectEuler1();
	pe.setLista(lista);
	
	System.out.println(lista);
	System.out.println("SUMA WYNOSI:  " +findTheSum(pe.getLista()));
	
	}

}
