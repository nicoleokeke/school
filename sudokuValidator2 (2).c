#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <ctype.h>

typedef struct
{
 int row;
 int column;
} parameters;

void * validateRows(void * params);
void * validateColumns(void * params);
void * validateSubgrid(void * params);

int board[9][9];



int main(void){
	
 FILE *fp;
 fp = fopen("puzzle.txt", "r");	
for (int i = 0; i < 9; i++)
{
    for (int j = 0; j < 9; j++)
    {
        fscanf(fp,"%d", &board[i][j]);
    }
    

}

//Solving Sudoku Board
int random;
srand(time(NULL));
for (int i = 0; i < 9; i++)
{
    for (int j = 0; j < 9; j++)
    {
        if (board[i][j] == 0)
        {
            random = 1 + rand() % 9;
            board[i][j] = random;
        }
        
    }
    
}

//Prints Solution to file
FILE *solution;

solution = fopen("solution.txt", "w+");
for(int s = 0; s < 9; s++){
	for(int t = 0; t < 9; t++){
		fprintf(solution, "%d", board[s][t]);
        
	}
    fprintf(solution, "\n");
}

//Initializing parameters for rows and columns

parameters *data = (parameters *) malloc(sizeof(parameters));
data->row = 0;
data->column = 0;
//Initializing parameters for subgrids
parameters *gridParam[9];

int row, column;
int i= 0;
for (row = 0; row < 9; row++) {
		for (column = 0; column < 9; column++) {						
			if (row%3 == 0 && column%3 == 0) {
				gridParam[i] = (parameters *) malloc(sizeof(parameters));	
				gridParam[i]->row = row;		
				gridParam[i]->column = column;
				i++;
                
			}
			
		}
	}
//Creating threads for rows and columns
	pthread_t tRows, tCols;
//Creating an array of threads for subgrids
	pthread_t tGrid[9];
//Initializing threads for rows and columns
    pthread_create(&tRows, NULL, validateRows, (void *) data);
    pthread_create(&tCols, NULL, validateColumns, (void *) data);
//Initializing threads for subgrids   
  int j;
  for(j = 0; j < 9; j++){
    pthread_create(&tGrid[j], NULL, validateSubgrid, (void *) gridParam[j]);
  }
  
  void * rowStatus;
  void * colStatus;
  void * subGridStatus[9];
  
  pthread_join(tRows, &rowStatus);
  pthread_join(tCols, &colStatus);
  
  
  int p;
  
  for(p = 0; p < 9; p++){
	  pthread_join(tGrid[p], (void *)&subGridStatus[p]);
  }
 
  int q;
  for (q = 0; q < 9; q++) {
		if (subGridStatus[q] == 0) {
			printf("INVALID!\n");
			return EXIT_SUCCESS;
		}
	}
    
	if(rowStatus == (void*)1 && colStatus == (void*)1){
		printf("VALID!\n");
		return EXIT_SUCCESS;
	}
    else printf ("INVALID!\n");
     
     

return 0;
  
}

void * validateSubgrid(void * params) {
    parameters * param = (parameters *) params;
    int Row = param->row;
    int Col = param->column;
    int validator[10] = {0};
    for (int i = Row; i < Row + 3; ++i) {
        for (int j = Col; j < Col + 3; ++j) {
            int number = board[i][j];
            if (validator[number] != 0) {
                pthread_exit((void*)0);
            }
            else{
                validator[number] = 1;
            }
        }
    }
    pthread_exit((void*)1);
}

void * validateRows(void * params) {
    parameters * param = (parameters *) params;
    int Row = param->row;
    int Col = param->column;
    for (int i = Row; i < 9; ++i) {
        int validator[10] = {0};
        for (int j = Col; j < 9; ++j) {
            int number = board[i][j];
            
            if (validator[number] != 0) {
                
                pthread_exit((void*)0);
            }
            else{
                validator[number] = 1;
            }
        }
    }
    pthread_exit((void*)1);
}


void * validateColumns(void * params) {
    parameters * param = (parameters *) params;
    int Row = param->row;
    int Col = param->column;
    for (int i = Col; i < 9; ++i) {
        int validator[10] = {0};
        for (int j = Row; j < 9; ++j) {
            int number = board[j][i];
            if (validator[number] != 0) {
                pthread_exit((void*)0);
            }
            else{
                validator[number] = 1;
            }
        }
    }
    pthread_exit((void*)1);
}