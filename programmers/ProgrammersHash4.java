import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ProgrammersHash4 {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/42579
	 * 베스트앨범
	 * 1. Genre별로 sum과 그에 따른 Pair(play/index) 쌍 리스트 를 담는다.
	 * => ArrayList<Genre> (HashMap이 아닌 ArrayList인 이유 : sorting하기 위해)
	 * 2. ArrayList에 담았으므로, ArrayList의 index와 Genre String을 매핑할 HashMap<String, Integer> 선언한다.
	 * 3. 우선 입력된 모든 값을 집어넣어준다. (넣을 때 sum은 계속 갱신해준다.)
	 * 4. ArrayList를 Genre.sum 내림차순으로 sort한다.
	 * 5. ArrayList 안의 Genre들의 list들을 play 횟수 내림차순, index 오름차순으로 sort한다.
	 * 6. 순서대로 출력한다.
	 * 
	 * */
	static class Genre {
		int sum;
		ArrayList<Pair> list;
		Genre(int sum, ArrayList<Pair> list) {
			this.sum = sum;
			this.list = list;
		}
		public void add(Pair p) {
			this.sum += p.plays;
			this.list.add(p);
		}
	}
	static class Pair {
		int index;
		int plays;
		Pair(int index, int plays) {
			this.index = index;
			this.plays = plays;
		}
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		ArrayList<Genre> genreList = new ArrayList<Genre>();
		HashMap<String, Integer> genreMap = new HashMap<String, Integer>();
		int curIndex = 0;
		for(int i = 0; i < genres.length; ++i) {
			Integer index = genreMap.get(genres[i]);
			if(index == null) {
				genreMap.put(genres[i], curIndex++);
				Pair p = new Pair(i, plays[i]);
				ArrayList<Pair> list = new ArrayList<Pair>();
				list.add(p);
				Genre g = new Genre(plays[i], list);
				genreList.add(g);
			} else {
				Pair p = new Pair(i, plays[i]);
				Genre g = genreList.get(genreMap.get(genres[i]));
				g.add(p);
				genreList.set(index, g);
			}
		}
		//sort each List
		Collections.sort(genreList, new Comparator<Genre>() {
			@Override
			public int compare(Genre a, Genre b) {
				int suma = a.sum;
				int sumb = b.sum;
				if(suma < sumb) return 1;
				else if(suma > sumb) return -1;
				else return 0;
			}
		});
		for(int i = 0; i < genreList.size(); ++i) {
			Genre g = genreList.get(i);
			ArrayList<Pair> l = g.list;
			Collections.sort(l, new Comparator<Pair> () {
				@Override
				public int compare(Pair a, Pair b) {
					if(a.plays < b.plays) return 1;
					else if(a.plays > b.plays) return -1;
					else {
						if(a.index < b.index) return -1;
						else if(a.index > b.index) return 1;
						else return 0;
					}
				}
			});
			g.list = l;
			genreList.set(i, g);
		}
		printGl(genreList);
		ArrayList<Integer> answerAl = new ArrayList<Integer>();
		boolean flag = false;
		for(int i = 0; i < genreList.size(); ++i) {
			for(int j = 0; j < (genreList.get(i).list.size() >= 2 ? 2 : genreList.get(i).list.size()); ++j) {
				answerAl.add(genreList.get(i).list.get(j).index);
			}
		}
		
		return arrayListToArray(answerAl);
	}
	public static int[] arrayListToArray(ArrayList<Integer> al) {
		int[] ret = new int[al.size()];
		for(int i = 0; i < al.size(); ++i) {
			ret[i] = al.get(i);
		}
		return ret;
	}
	public static void printGl(ArrayList<Genre> gl) {
		for(int i = 0; i < gl.size(); ++i) {
			System.out.println(gl.get(i).sum);
			for(int j = 0; j < gl.get(i).list.size(); ++j) {
				System.out.print(gl.get(i).list.get(j).index + "/" + gl.get(i).list.get(j).plays + " ");
			}
			System.out.println();
		}
	}
	public static void printAl(ArrayList<Integer> al) {
		for(int i = 0; i < al.size(); ++i) {
			System.out.print(al.get(i) + " ");
		}
		System.out.println();
	}
	public static void print(int[] a) {
		for(int i = 0; i < a.length; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		String[] genres1 = {"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"};
		int[] plays1 = {500, 600, 150, 800, 2500, 2100, 1000};
		
		String[] genres2 = {"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"};
		int[] plays2 = {0, 0, 1, 0, 3, 2, 0};
		print(solution(genres, plays));
		System.out.println();
		print(solution(genres1, plays1));
		System.out.println();
		print(solution(genres2, plays2));
	}
}
