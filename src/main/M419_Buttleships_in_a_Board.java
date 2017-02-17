package main;

public class M419_Buttleships_in_a_Board {
	
	
	/**
	 * 20170116
	 * Yangdi
	 * Accepted
	 */
    public int countBattleships(char[][] board) {
        int n_ships = 0;
        int m = board.length;
        int n = board[0].length;
        char neibor[] = new char[4];
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(board[i][j] == 'X'){
        			//左
        			neibor[0] = (j==0)?'.':board[i][j-1];
        			//上
        			neibor[1] = (i==0)?'.':board[i-1][j];
        			//右
        			neibor[2] = (j==n-1)?'.':board[i][j+1];
        			//下
        			neibor[3] = (i==m-1)?'.':board[i+1][j];
        			
        			//检查是否是非法军舰
        			//左为X，上下中有一X,非法
        			if(neibor[0] == 'X' && (neibor[0] == neibor[1] || neibor[0] == neibor[3]))
        				return 0;
        			//右为X，上下中有一X,非法
        			if(neibor[2] == 'X' && (neibor[2] == neibor[1] || neibor[2] == neibor[3]))
        				return 0;
        			
        			//左上没有X，则是新的一个军舰
        			if(neibor[0] == '.' && neibor[0] == neibor[1])
        				n_ships++;        				

        		}
        	}
        }
        
        return n_ships;
    }
    
}
