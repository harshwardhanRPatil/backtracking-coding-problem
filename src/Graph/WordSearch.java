package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class WordSearchSolution {
  public boolean exist(char[][] board, String word) {
    boolean ans = false;
    List<List<Integer>> direction =
        Arrays.asList(
            Arrays.asList(-1, 0), Arrays.asList(0, -1), Arrays.asList(0, 1), Arrays.asList(1, 0));
    List<List<Integer>> visited = new ArrayList<>();
    int X = board.length;
    int Y = board[0].length;
    if((X*Y)<word.length()){
        return false;
    }
    System.out.println(X +" "+Y);
    for (int i = 0; i < X; i++) {
      visited.add(new ArrayList<>(Collections.nCopies(Y, 0)));
    }

    for (int i = 0; i < X; i++) {
      for (int j = 0; j < Y; j++) {
        System.out.println((board[i][j]==word.charAt(0))+"::"+i+j);
        if ((board[i][j]==word.charAt(0))) {
            visited.get(i).set(j,1);
          ans = stringFinder(i, j, visited, direction, board, word, 1, ans);
          if (ans) {
            return ans;
          }
            visited.get(i).set(j,0);
        }

      }
        System.out.println(visited.toString());
    }
    return ans;
  }

  public boolean stringFinder(
      int node_x,
      int node_y,
      List<List<Integer>> visited,
      List<List<Integer>> direction,
      char[][] board,
      String word,
      int Position,
      boolean ans) {

    if (Position == word.length()) {
      return true;
    }
    System.out.println("we");
    for (int i = 0; i < direction.size(); i++) {
      int new_x = node_x + direction.get(i).get(0);
      int new_y = node_y + direction.get(i).get(1);
        System.out.println(node_x+"::"+node_y+"::"+visited.toString()+ "::  for ::"+new_x+" "+new_y);
      if (new_y >= 0
          && new_x >= 0
          && new_x < board.length
          && new_y < board[0].length
          && visited.get(new_x).get(new_y) == 0) {
        if ((word.charAt(Position)==board[new_x][new_y]) ) {
          visited.get(new_x).set(new_y, 1);
          ans =
              ans || stringFinder(new_x, new_y, visited, direction, board, word, Position + 1, ans);
          if (ans) {
            return ans;
            }
          visited.get(new_x).set(new_y, 0);
        }
      }
    }
    return ans;
  }
}

public class WordSearch {
  public static void main(String args[]) {
    WordSearchSolution wordSearchSolution = new WordSearchSolution();
//    System.out.println(
//        wordSearchSolution.exist(
//            new char[][] {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB"));
      System.out.println(
              wordSearchSolution.exist(
                      new char[][] {{'A', 'A'},{'a','a'}}, "AAA"));
  }
}
