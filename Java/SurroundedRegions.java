// DFS recursive, stackoverflow
public void solve(char[][] board) {
    if (board == null || board.length == 0)
        return;
    // check four boundaries
    for (int i = 0; i < board[0].length; i++) {
        // first row
        if (board[0][i] == 'O')
            dfs(0, i, board);
        // last row
        if (board[board.length - 1][i] == 'O')
            dfs(board.length - 1, i, board);
    }
    // check four boundaries
    for (int i = 0; i < board.length; i++) {
        // first column
        if (board[i][0] == 'O')
            dfs(i, 0, board);
        // last column
        if (board[i][board[0].length - 1] == 'O')
            dfs(i, board[0].length - 1, board);
    }
    // set all the rest 'O' to 'X', 'B' to 'O'
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == 'B')
                board[i][j] = 'O';
            else if (board[i][j] == 'O')
                board[i][j] = 'X';
        }
    }
}

// DFS & set to 'B'
private void dfs(int i, int j, char[][] board) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
        || board[i][j] == 'X' || board[i][j] == 'B')
        return;
    board[i][j] = 'B';
    dfs(i - 1, j, board);
    dfs(i + 1, j, board);
    dfs(i, j - 1, board);
    dfs(i, j + 1, board);
}


// DFS, iterative
class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public void solve(char[][] board) {
    if (board == null || board.length == 0)
        return;
    // check four boundaries
    for (int i = 0; i < board[0].length; i++) {
        // first row
        if (board[0][i] == 'O')
            dfs(0, i, board);
        // last row
        if (board[board.length - 1][i] == 'O')
            dfs(board.length - 1, i, board);
    }
    // check four boundaries
    for (int i = 0; i < board.length; i++) {
        // first column
        if (board[i][0] == 'O')
            dfs(i, 0, board);
        // last column
        if (board[i][board[0].length - 1] == 'O')
            dfs(i, board[0].length - 1, board);
    }
    // set all the rest 'O' to 'X', 'B' to 'O'
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == 'B')
                board[i][j] = 'O';
            else if (board[i][j] == 'O')
                board[i][j] = 'X';
        }
    }
}

// DFS & set to 'B'
private void dfs(int i, int j, char[][] board) {
    Stack<Pair> stack = new Stack<Pair>();
    Pair pair = new Pair(i,j);
    stack.push(pair);
    while (!stack.isEmpty()) {
        Pair root = stack.pop();
        int X = root.i;
        int Y = root.j;
        board[X][Y] = 'B';
        int x, y;
        // up
        x = X - 1;
        y = Y;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            stack.push(child);
        }
        // down
        x = X + 1;
        y = Y;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            stack.push(child);
        }
        // left
        x = X;
        y = Y - 1;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            stack.push(child);
        }
        // right
        x = X;
        y = Y + 1;
        if (!(x < 0 || y < 0 || x >= board.length || y >= board[0].length 
            || board[x][y] == 'X' || board[x][y] == 'B')) {
            Pair child = new Pair(x,y);
            stack.push(child);
        }
    }
}
