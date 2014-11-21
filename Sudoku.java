/**
Method 1
DFS simplest way.  no track of visited number

*/
public void solveSudoku(char[][] board) {
    if(board == null || board.length != 9 || board[0].length !=9)
        return;
    helper(board,0,0);
}
private boolean helper(char[][] board, int i, int j)
{
    if(j>=9)
        return helper(board,i+1,0);
    if(i==9)
    {
        return true;
    }
    if(board[i][j]=='.')
    {
        for(int k=1;k<=9;k++)
        {
            board[i][j] = (char)(k+'0');
            if(isValid(board,i,j))
            {
                if(helper(board,i,j+1))
                    return true;
            }
            board[i][j] = '.';
        }
    }
    else
    {
        return helper(board,i,j+1);
    }
    return false;
}
private boolean isValid(char[][] board, int i, int j)
{
    for(int k=0;k<9;k++)
    {
        if(k!=j && board[i][k]==board[i][j])
            return false;
    }
    for(int k=0;k<9;k++)
    {
        if(k!=i && board[k][j]==board[i][j])
            return false;
    }        
    for(int row = i/3*3; row<i/3*3+3; row++)
    {
        for(int col=j/3*3; col<j/3*3+3; col++)
        {
            if((row!=i || col!=j) && board[row][col]==board[i][j])
                return false;
        }
    }
    return true;
}


/**
Method 2
DFS.  Use HashSet or BitMap to record visited number.  reduce time by increase space
http://www.cnblogs.com/TenosDoIt/p/3800485.html
*/
class Solution {
public:
    void solveSudoku(vector<vector<char> > &board) {
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j] != '.')
                    fill(i, j, board[i][j] - '0');
        solver(board, 0);
    }
     
    bool solver(vector<vector<char> > &board, int index)
    {// 0 <= index <= 80，index表示接下来要填充第index个格子
        if(index > 80)return true;
        int row = index / 9, col = index - 9*row;
        if(board[row][col] != '.')
            return solver(board, index+1);
        for(int val = '1'; val <= '9'; val++)//每个为填充的格子有9种可能的填充数字
        {
            if(isValid(row, col, val-'0'))
            {
                board[row][col] = val;
                fill(row, col, val-'0');
                if(solver(board, index+1))return true;
                clear(row, col, val-'0');
            }
        }
        board[row][col] = '.';//注意别忘了恢复board状态
        return false;
    }
     
    //判断在第row行col列填充数字val后，是否是合法的状态
    bool isValid(int row, int col, int val)
    {
        if(rowValid[row][val] == 0 &&
           columnValid[col][val] == 0 &&
           subBoardValid[row/3*3+col/3][val] == 0)
           return true;
        return false;
    }
     
    //更新填充状态
    void fill(int row, int col, int val)
    {
        rowValid[row][val] = 1;
        columnValid[col][val] = 1;
        subBoardValid[row/3*3+col/3][val] = 1;
    }
     
    //清除填充状态
    void clear(int row, int col, int val)
    {
        rowValid[row][val] = 0;
        columnValid[col][val] = 0;
        subBoardValid[row/3*3+col/3][val] = 0;
    }
private:
    int rowValid[9][10];//rowValid[i][j]表示第i行数字j是否已经使用
    int columnValid[9][10];//columnValid[i][j]表示第i列数字j是否已经使用
    int subBoardValid[9][10];//subBoardValid[i][j]表示第i个小格子内数字j是否已经使用
}


/**
Method3
Note: Search (solution) problem can be either DFS or BFS.
BFS.  
http://yucoding.blogspot.com/2013/12/leetcode-question-sudoku-solver.html
*/
class Solution {
public:
    bool find(vector<vector<char> > &cur, int &i, int &j){
        for (int ii=0;ii<9;ii++){
            for (int jj=0;jj<9;jj++){
                if (cur[ii][jj]=='.'){
                    i=ii;
                    j=jj;
                    return true;
                }
            }
        }
        return false;
    }
     
    unordered_set<char> valid(int i, int j, vector<vector<char> > &cur){
        unordered_set<char> se({'1','2','3','4','5','6','7','8','9'});
        for (int ii=0;ii<9;ii++){
            se.erase(cur[ii][j]);
            se.erase(cur[i][ii]);
        }
         
        for (int ii=0;ii<3;ii++){
            for (int jj=0;jj<3;jj++){
                se.erase(cur[(i/3)*3+ii][(j/3)*3+jj]);
            }
        }
         
        return se;
         
    }
    void solveSudoku(vector<vector<char> > &board) {
        queue<vector<vector<char> > > que;
        que.push(board);
        vector<vector<char> > cur;
        unordered_set<char> se;
        int i=0;
        int j=0;
        while (!que.empty()){
            cur = que.front();
            que.pop();
            if (find(cur,i,j)==false){
                board = cur;
                return;
            }else{
                se = valid(i,j,cur);
                for (const char& x: se){
                    cur[i][j]=x;
                    que.push(cur);  
                }
            }
        }
    }
}

