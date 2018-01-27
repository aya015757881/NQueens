package aya;

import java.util.Scanner;

public class NQueens {
	
	int[] chessboard;
	int N, count;
	Scanner cin = new Scanner(System.in);
	
	public static void main(String[] args){
		
		new NQueens().go();
	}
	
	void go(){
		
		while(true){
			
			count = 0;
			System.out.print("请输入N皇后的N值，N=");
			N = cin.nextInt();
			chessboard = new int[N];
			double start = System.currentTimeMillis();
			
			nQueens(0);
			
			System.out.println(N + "皇后共有"+count+"种摆法\n耗时：" + (System.currentTimeMillis() - start) / 1000 + "秒\n\n");
		}
	}
	
	void nQueens(int row){
		
		for(chessboard[row] = 0; chessboard[row] < N; ++chessboard[row]){
			if(capturesAnotherQueenAhead(row))
				continue;
			if(row < N - 1)
				nQueens(row + 1);
			else
				printChessboard();
		}
	}
	
	boolean capturesAnotherQueenAhead(int row){
		
		int column = chessboard[row];
		
		for(int i = 0; i < row; ++i)
			if(Math.abs(column - chessboard[i]) == row - i || column == chessboard[i])
				return true;
		
		return false;
	}
	
	void printChessboard(){
		
		count++;
		System.out.println("这是第"+count+"种摆法");
		
		for(int i = 0; i < N; ++i){
			for(int j = 0; j < N; ++j)
				if(j != chessboard[i])
					System.out.print("* ");
				else
					System.out.print("$ ");
			
			System.out.println();
		}
		
		System.out.println();
	}
}







