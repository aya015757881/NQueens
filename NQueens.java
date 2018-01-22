package aya;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;
public class NQueens
{
	static int count;
	
	public static void main(String[] args)
	{
		int N,chessboard[];
		Scanner cin=new Scanner(System.in);
		while(true)
		{
			count=0;
			System.out.print("������N�ʺ��Nֵ��N=");
			N=cin.nextInt();
			chessboard=new int[N];
			double start = System.currentTimeMillis();
			nQueens(chessboard,0,N);
			System.out.println(N+"�ʺ���"+count+"�ְڷ�\n��ʱ��"+(System.currentTimeMillis()-start)/1000+"��\n\n");
		}
	}
	
	static void nQueens(int[] chessboard,int row,int N)
	{
		for(chessboard[row]=0;chessboard[row]<N;chessboard[row]++)
		{
			if(capturesAnotherQueenAhead(chessboard,row))
				continue;
			if(row<N-1)
				nQueens(chessboard,row+1,N);
			else
				printChessboard(chessboard,N);
		}
	}
	
	static boolean capturesAnotherQueenAhead(int[] chessboard,int row)
	{
		int column=chessboard[row];
		for(int i=0;i<row;i++)
			if(Math.abs(column-chessboard[i])==row-i||column==chessboard[i])
				return true;
		return false;
	}
	
	static void printChessboard(int[] chessboard,int N)
	{
		count++;
		System.out.println("���ǵ�"+count+"�ְڷ�");
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
				if(j!=chessboard[i])
					System.out.print("* ");
				else
					System.out.print("$ ");
			System.out.println();
		}
		System.out.println();
	}
}


