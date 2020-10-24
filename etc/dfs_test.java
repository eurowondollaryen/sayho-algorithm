import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
1로 된 영역의 개수와 면적을 구하시오
입력
6
0 1 1 0 0 0
0 1 1 0 1 1
0 0 0 0 1 1
0 0 0 0 1 1
1 1 0 0 1 0
1 1 1 0 0 0
출력
3
4 5 7
*/
class Main {
	private static int currentCount;
	private static ArrayList<Integer> sizes;
  private static void solution(int sizeOfMatrix, int[][] matrix) {
    // TODO: 이곳에 코드를 작성하세요.
		sizes = new ArrayList<Integer>();
		boolean[][] visit = new boolean[sizeOfMatrix][sizeOfMatrix];
		for(int i = 0; i < visit.length; ++i) {
			for(int j = 0; j < visit[i].length; ++j) {
				visit[i][j] = false;
			}
		}
		
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[i].length; ++j) {
				if(matrix[i][j] != 0 && !visit[i][j]) {
					currentCount = 0;
					dfs(i, j, matrix, visit);
					sizes.add(currentCount);
				}
			}
		}
		Collections.sort(sizes, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b);
			}
		});
		if(sizes.size() == 0) System.out.println("0");
		else {
			System.out.println(sizes.size());
			print(sizes);
		}
  }
	private static void print(ArrayList<Integer> a) {
		for(int i = 0; i < a.size(); ++i) {
			if(i != a.size()-1) System.out.print(a.get(i) + " ");
			else System.out.println(a.get(i));
		}
	}
	private static void dfs(int posi, int posj, int[][] matrix, boolean[][] visit) {
		visit[posi][posj] = true;
		currentCount++;
		//상하좌우로 0이거나 벽인 경우, visited 제외하고 방문하기
		//up
		if(posi-1 >= 0) {
			if(matrix[posi-1][posj] != 0 && !visit[posi-1][posj]) dfs(posi-1, posj, matrix, visit);
		}
		//down
		if(posi+1 < matrix.length) {
			if(matrix[posi+1][posj] != 0 && !visit[posi+1][posj]) dfs(posi+1, posj, matrix, visit);
		}
		
		//left
		if(posj-1 >= 0) {
			if(matrix[posi][posj-1] != 0 && !visit[posi][posj-1]) dfs(posi, posj-1, matrix, visit);
		}
		
		//right
		if(posj+1 < matrix.length) {
			if(matrix[posi][posj+1] != 0 && !visit[posi][posj+1]) dfs(posi, posj+1, matrix, visit);
		}
	}
  
  private static class InputData {
    int sizeOfMatrix;
    int[][] matrix;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      
      inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
      for (int i = 0; i < inputData.sizeOfMatrix; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.sizeOfMatrix; j++) {
          inputData.matrix[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.sizeOfMatrix, inputData.matrix);
  }
}