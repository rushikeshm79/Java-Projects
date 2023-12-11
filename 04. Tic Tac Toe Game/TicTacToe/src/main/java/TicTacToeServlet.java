package main.java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TicTacToeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int row = Integer.parseInt(request.getParameter("row"));
        int col = Integer.parseInt(request.getParameter("col"));

        if (board[row][col] == '\u0000') { // Check if the cell is empty
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        response.sendRedirect("/TicTacToeGame/");
    }

    @Override
    public void init() throws ServletException {
        // Initialize the board with empty cells
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '\u0000';
            }
        }
    }
