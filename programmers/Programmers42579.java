import java.util.*;
class Solution {
    class Song {
        Integer id;
        String genre;
        Integer plays;
        Song(Integer id, String genre, Integer plays) {
            this.id = id;
            this.genre = genre;
            this.plays = plays;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> genreCount = new HashMap<String, Integer>();
        //sort이후에 원래값 찾기위해
        ArrayList<Song> arrayListSong = new ArrayList<Song>();
        
        for(int i = 0; i < genres.length; ++i) {
            //장르별 전체 재생수를 카운트
            if(genreCount.get(genres[i]) == null) {
                genreCount.put(genres[i], plays[i]);
            } else {
                genreCount.put(genres[i], genreCount.get(genres[i]) + plays[i]);
            }
            //sort를 위해 Song ArrayList에 push
            Song song = new Song(i, genres[i], plays[i]);
            arrayListSong.add(song);
        }
        
        Collections.sort(arrayListSong, new Comparator<Song>() {
            @Override
            public int compare(Song song1, Song song2) {
                //양수면 song1, 음수면 song2
                //1. 장르 총 재생수 비교
                if(genreCount.get(song1.genre) > genreCount.get(song2.genre)) return -1;
                else if(genreCount.get(song1.genre) < genreCount.get(song2.genre)) return 1;
                else {
                    //2. 장르 내에서 많이 재생된 노래
                    if(song1.plays > song2.plays) return -1;
                    else if(song1.plays < song2.plays) return 1;
                    else {
                        //3. 장르, 재생횟수가 같으면 고유번호가 낮은 노래 먼저
                        return song2.id - song1.id;
                    }
                }
            }
        });
        HashMap<String, Integer> answerCount = new HashMap<String, Integer>();
        ArrayList<Integer> answerArrayList = new ArrayList<Integer>();
        
        for(int i = 0; i < arrayListSong.size(); ++i) {
            //System.out.println(arrayListSong.get(i).id + ", " + arrayListSong.get(i).genre + ", " + arrayListSong.get(i).plays);
            Integer currentId = arrayListSong.get(i).id;
            if(answerCount.get(arrayListSong.get(i).genre) == null) {
                answerArrayList.add(currentId);
                answerCount.put(arrayListSong.get(i).genre, 1);
            } else if(answerCount.get(arrayListSong.get(i).genre) == 2) {
                continue;
            } else {
                answerArrayList.add(currentId);
                answerCount.put(arrayListSong.get(i).genre, answerCount.get(arrayListSong.get(i).genre) + 1);
            }
        }
        answer = new int[answerArrayList.size()];
        for(int i = 0; i < answerArrayList.size(); ++i) {
            answer[i] = answerArrayList.get(i);
        }
        return answer;
    }
}