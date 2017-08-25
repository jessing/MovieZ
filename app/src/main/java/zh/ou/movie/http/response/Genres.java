package zh.ou.movie.http.response;

import java.util.List;

/**
 * author:   zhoux
 * date:    2017/8/25
 * email:   13617694689@163.com
 */

public class Genres {

    private List<GenresBean> genres;

    public List<GenresBean> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresBean> genres) {
        this.genres = genres;
    }

    public static class GenresBean {
        /**
         * id : 28
         * name : 动作
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
