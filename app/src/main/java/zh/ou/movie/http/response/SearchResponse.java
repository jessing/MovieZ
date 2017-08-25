package zh.ou.movie.http.response;

import java.util.List;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public class SearchResponse {

    /**
     * page : 1
     * total_results : 4
     * total_pages : 1
     * results : [{"vote_count":76,"id":13995,"video":false,"vote_average":4.5,"title":"Captain America","popularity":3.967751,"poster_path":"/umO9ZJ63dNtT6Z5ZehNunGn884I.jpg","original_language":"en","original_title":"Captain America","genre_ids":[28,878,10752],"backdrop_path":"/a1tNE5nsAMIMpBs0yrweIdzXymO.jpg","adult":false,"overview":"During World War II, a brave, patriotic American Soldier undergoes experiments to become a new supersoldier, \"Captain America.\" Racing to Germany to sabotage the rockets of Nazi baddie \"Red Skull\", Captain America winds up frozen until the 1990s. He reawakens to find that the Red Skull has changed identities and is now planning to kidnap the President of the United States.","release_date":"1990-12-14"},{"vote_count":6897,"id":271110,"video":false,"vote_average":7,"title":"Captain America: Civil War","popularity":14.602453,"poster_path":"/kSBXou5Ac7vEqKd97wotJumyJvU.jpg","original_language":"en","original_title":"Captain America: Civil War","genre_ids":[12,28,878],"backdrop_path":"/m5O3SZvQ6EgD5XXXLPIP1wLppeW.jpg","adult":false,"overview":"Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.","release_date":"2016-04-27"},{"vote_count":6705,"id":1771,"video":false,"vote_average":6.6,"title":"Captain America: The First Avenger","popularity":5.729596,"poster_path":"/vSNxAJTlD0r02V9sPYpOjqDZXUK.jpg","original_language":"en","original_title":"Captain America: The First Avenger","genre_ids":[28,12,878],"backdrop_path":"/pmZtj1FKvQqISS6iQbkiLg5TAsr.jpg","adult":false,"overview":"Predominantly set during World War II, Steve Rogers is a sickly man from Brooklyn who's transformed into super-soldier Captain America to aid in the war effort. Rogers must stop the Red Skull \u2013 Adolf Hitler's ruthless head of weaponry, and the leader of an organization that intends to use a mysterious device of untold powers for world domination.","release_date":"2011-07-22"},{"vote_count":5459,"id":100402,"video":false,"vote_average":7.6,"title":"Captain America: The Winter Soldier","popularity":6.504361,"poster_path":"/5TQ6YDmymBpnF005OyoB7ohZps9.jpg","original_language":"en","original_title":"Captain America: The Winter Soldier","genre_ids":[28,12,878],"backdrop_path":"/4qfXT9BtxeFuamR4F49m2mpKQI1.jpg","adult":false,"overview":"After the cataclysmic events in New York with The Avengers, Steve Rogers, aka Captain America is living quietly in Washington, D.C. and trying to adjust to the modern world. But when a S.H.I.E.L.D. colleague comes under attack, Steve becomes embroiled in a web of intrigue that threatens to put the world at risk. Joining forces with the Black Widow, Captain America struggles to expose the ever-widening conspiracy while fighting off professional assassins sent to silence him at every turn. When the full scope of the villainous plot is revealed, Captain America and the Black Widow enlist the help of a new ally, the Falcon. However, they soon find themselves up against an unexpected and formidable enemy\u2014the Winter Soldier.","release_date":"2014-03-20"}]
     */

    private int page;
    private int total_results;
    private int total_pages;
    private List<ResultsBean> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * vote_count : 76
         * id : 13995
         * video : false
         * vote_average : 4.5
         * title : Captain America
         * popularity : 3.967751
         * poster_path : /umO9ZJ63dNtT6Z5ZehNunGn884I.jpg
         * original_language : en
         * original_title : Captain America
         * genre_ids : [28,878,10752]
         * backdrop_path : /a1tNE5nsAMIMpBs0yrweIdzXymO.jpg
         * adult : false
         * overview : During World War II, a brave, patriotic American Soldier undergoes experiments to become a new supersoldier, "Captain America." Racing to Germany to sabotage the rockets of Nazi baddie "Red Skull", Captain America winds up frozen until the 1990s. He reawakens to find that the Red Skull has changed identities and is now planning to kidnap the President of the United States.
         * release_date : 1990-12-14
         */

        private int vote_count;
        private int id;
        private boolean video;
        private double vote_average;
        private String title;
        private double popularity;
        private String poster_path;
        private String original_language;
        private String original_title;
        private String backdrop_path;
        private boolean adult;
        private String overview;
        private String release_date;
        private List<Integer> genre_ids;



        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}
