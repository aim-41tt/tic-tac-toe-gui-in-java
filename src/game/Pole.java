package game;

public class Pole {
	
		public char pole [][] = new char [3][3];
		private boolean flag;
		private char znak='x';
		
		public Pole() {
			resetPole();
		}
		
		public char getznak() {
			return znak;
		}
		
		public void resetPole() {
			for(int i=0;i<pole.length;i++) {
				for(int j=0;j<pole[0].length;j++) {
					pole[i][j] = ' ';
				}	
			}
		}
		
		public void User_hod( int x, int y) {
			if(pole[x][y] == ' ') 
			if(flag) {
				znak ='X';
				flag=false;
				hod_pole(x, y);
			}else {
				znak ='O';
				flag=true;
				hod_pole(x, y);
			}
		}
		
		private void hod_pole(int x,int y) {
			
			pole[x][y]=znak;
			
			
		}
		
		public String poleGame(){
			String pole_g="";
			for(int i=0;i<pole.length;i++) {
				for(int j=0;j<pole[0].length;j++) {
					pole_g+=pole[i][j];
				}	
				pole_g+="\n";
			}
			return pole_g;
		}
		
		private int testvin(char mas[][]) {
			for (int i = 0; i < 3; i++) {
	            if (mas[i][0] != ' ' && mas[i][0] == mas[i][1] && mas[i][1] == mas[i][2]) {
	                return i; // победитель в строке i
	            }
	            
	            if (mas[0][i] != ' ' && mas[0][i] == mas[1][i] && mas[1][i] == mas[2][i]) {
	                return i+3; // победитель в столбце i
	            }
	        }
	        
	        // проверка диагоналей
	        if (mas[0][0] != ' ' && mas[0][0] == mas[1][1] && mas[1][1] == mas[2][2]) {
	            return 6; // победитель на главной диагонали
	        }
	        
	        if (mas[0][2] != ' ' && mas[0][2] == mas[1][1] && mas[1][1] == mas[2][0]) {
	            return 7; // победитель на побочной диагонали
	        }
			return -1;
		}
		
		public int pravVin() {
			return testvin(pole);
		}
		
		
	}


