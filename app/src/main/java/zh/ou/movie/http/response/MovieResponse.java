package zh.ou.movie.http.response;

import java.io.Serializable;
import java.util.List;

/**
 * author:   zhoux
 * date:    2017/8/24
 * email:   13617694689@163.com
 */

public class MovieResponse implements Serializable{

    /**
     * page : 1
     * total_results : 19531
     * total_pages : 977
     * results : [{"vote_count":4185,"id":211672,"video":false,"vote_average":6.4,"title":"Minions","popularity":220.212696,"poster_path":"/q0R4crx2SehcEEQEkYObktdeFy.jpg","original_language":"en","original_title":"Minions","genre_ids":[10751,16,12,35],"backdrop_path":"/uX7LXnsC7bZJZjn048UCOwkPXWJ.jpg","adult":false,"overview":"Minions Stuart, Kevin and Bob are recruited by Scarlet Overkill, a super-villain who, alongside her inventor husband Herb, hatches a plot to take over the world.","release_date":"2015-06-17"},{"vote_count":4790,"id":321612,"video":false,"vote_average":6.8,"title":"Beauty and the Beast","popularity":112.725296,"poster_path":"/tWqifoYuwLETmmasnGHO7xBjEtt.jpg","original_language":"en","original_title":"Beauty and the Beast","genre_ids":[10751,14,10749],"backdrop_path":"/6aUWe0GSl69wMTSWWexsorMIvwU.jpg","adult":false,"overview":"A live-action adaptation of Disney's version of the classic 'Beauty and the Beast' tale of a cursed prince and a beautiful young woman who helps him break the spell.","release_date":"2017-03-16"},{"vote_count":406,"id":396422,"video":false,"vote_average":6.3,"title":"Annabelle: Creation","popularity":77.516954,"poster_path":"/tb86j8jVCVsdZnzf8I6cIi65IeM.jpg","original_language":"en","original_title":"Annabelle: Creation","genre_ids":[53,27],"backdrop_path":"/o8u0NyEigCEaZHBdCYTRfXR8U4i.jpg","adult":false,"overview":"Several years after the tragic death of their little girl, a dollmaker and his wife welcome a nun and several girls from a shuttered orphanage into their home, soon becoming the target of the dollmaker's possessed creation, Annabelle.","release_date":"2017-08-09"},{"vote_count":2599,"id":315635,"video":false,"vote_average":7.3,"title":"Spider-Man: Homecoming","popularity":76.109106,"poster_path":"/c24sv2weTHPsmDa7jEMN0m2P3RT.jpg","original_language":"en","original_title":"Spider-Man: Homecoming","genre_ids":[28,12,878],"backdrop_path":"/vc8bCGjdVp0UbMNLzHnHSLRbBWQ.jpg","adult":false,"overview":"Following the events of Captain America: Civil War, Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in Queens, New York City, with fighting crime as his superhero alter ego Spider-Man as a new threat, the Vulture, emerges.","release_date":"2017-07-05"},{"vote_count":3756,"id":283995,"video":false,"vote_average":7.6,"title":"Guardians of the Galaxy Vol. 2","popularity":58.269522,"poster_path":"/y4MBh0EjBlMuOzv9axM4qJlmhzz.jpg","original_language":"en","original_title":"Guardians of the Galaxy Vol. 2","genre_ids":[28,12,35,878],"backdrop_path":"/aJn9XeesqsrSLKcHfHP4u5985hn.jpg","adult":false,"overview":"The Guardians must fight to keep their newfound family together as they unravel the mysteries of Peter Quill's true parentage.","release_date":"2017-04-19"},{"vote_count":1162,"id":281338,"video":false,"vote_average":6.7,"title":"War for the Planet of the Apes","popularity":55.454994,"poster_path":"/y52mjaCLoJJzxfcDDlksKDngiDx.jpg","original_language":"en","original_title":"War for the Planet of the Apes","genre_ids":[18,878,10752],"backdrop_path":"/ulMscezy9YX0bhknvJbZoUgQxO5.jpg","adult":false,"overview":"Caesar and his apes are forced into a deadly conflict with an army of humans led by a ruthless Colonel. After the apes suffer unimaginable losses, Caesar wrestles with his darker instincts and begins his own mythic quest to avenge his kind. As the journey finally brings them face to face, Caesar and the Colonel are pitted against each other in an epic battle that will determine the fate of both their species and the future of the planet.","release_date":"2017-07-11"},{"vote_count":1351,"id":324852,"video":false,"vote_average":6.2,"title":"Despicable Me 3","popularity":54.961275,"poster_path":"/5qcUGqWoWhEsoQwNUrtf3y3fcWn.jpg","original_language":"en","original_title":"Despicable Me 3","genre_ids":[878,12,16,35,10751],"backdrop_path":"/puV2PFq42VQPItaygizgag8jrXa.jpg","adult":false,"overview":"Gru and his wife Lucy must stop former '80s child star Balthazar Bratt from achieving world domination.","release_date":"2017-06-15"},{"vote_count":1406,"id":374720,"video":false,"vote_average":7.4,"title":"Dunkirk","popularity":43.292505,"poster_path":"/bOXBV303Fgkzn2K4FeKDc0O31q4.jpg","original_language":"en","original_title":"Dunkirk","genre_ids":[28,18,36,53,10752],"backdrop_path":"/fudEG1VUWuOqleXv6NwCExK0VLy.jpg","adult":false,"overview":"Miraculous evacuation of Allied soldiers from Belgium, Britain, Canada, and France, who were cut off and surrounded by the German army from the beaches and harbor of Dunkirk, France, between May 26 and June 04, 1940, during Battle of France in World War II.","release_date":"2017-07-19"},{"vote_count":8968,"id":118340,"video":false,"vote_average":7.9,"title":"Guardians of the Galaxy","popularity":40.89527,"poster_path":"/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg","original_language":"en","original_title":"Guardians of the Galaxy","genre_ids":[28,878,12],"backdrop_path":"/bHarw8xrmQeqf3t8HpuMY7zoK4x.jpg","adult":false,"overview":"Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.","release_date":"2014-07-30"},{"vote_count":307,"id":353491,"video":false,"vote_average":5.7,"title":"The Dark Tower","popularity":38.637079,"poster_path":"/i9GUSgddIqrroubiLsvvMRYyRy0.jpg","original_language":"en","original_title":"The Dark Tower","genre_ids":[28,37,878,14,27],"backdrop_path":"/2n7Zn6WxJ76ccOwnuQHuhSFMbqt.jpg","adult":false,"overview":"The last Gunslinger, Roland Deschain, has been locked in an eternal battle with Walter O\u2019Dim, also known as the Man in Black, determined to prevent him from toppling the Dark Tower, which holds the universe together. With the fate of the worlds at stake, good and evil will collide in the ultimate battle as only Roland can defend the Tower from the Man in Black.","release_date":"2017-08-03"},{"vote_count":10061,"id":157336,"video":false,"vote_average":8.1,"title":"Interstellar","popularity":36.670059,"poster_path":"/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg","original_language":"en","original_title":"Interstellar","genre_ids":[12,18,878],"backdrop_path":"/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg","adult":false,"overview":"Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.","release_date":"2014-11-05"},{"vote_count":1109,"id":339846,"video":false,"vote_average":6,"title":"Baywatch","popularity":33.859095,"poster_path":"/6HE4xd8zloDqmjMZuhUCCw2UcY1.jpg","original_language":"en","original_title":"Baywatch","genre_ids":[28,35],"backdrop_path":"/tryI7qZHaLMVzMNpLyKHKDiZOLc.jpg","adult":false,"overview":"Devoted lifeguard Mitch Buchannon butts heads with a brash new recruit. Together, they uncover a local criminal plot that threatens the future of the Bay.","release_date":"2017-05-12"},{"vote_count":2117,"id":126889,"video":false,"vote_average":5.7,"title":"Alien: Covenant","popularity":33.85249,"poster_path":"/zecMELPbU5YMQpC81Z8ImaaXuf9.jpg","original_language":"en","original_title":"Alien: Covenant","genre_ids":[27,878,53],"backdrop_path":"/kMU8trT43p5LFoJ4plIySMOsZ1T.jpg","adult":false,"overview":"Bound for a remote planet on the far side of the galaxy, the crew of the colony ship 'Covenant' discovers what is thought to be an uncharted paradise, but is actually a dark, dangerous world \u2013 which has its sole inhabitant the 'synthetic', David, survivor of the doomed Prometheus expedition.","release_date":"2017-05-09"},{"vote_count":8160,"id":135397,"video":false,"vote_average":6.5,"title":"Jurassic World","popularity":32.498552,"poster_path":"/jjBgi2r5cRt36xF6iNUEhzscEcb.jpg","original_language":"en","original_title":"Jurassic World","genre_ids":[28,12,878,53],"backdrop_path":"/dkMD5qlogeRMiEixC4YNPUvax2T.jpg","adult":false,"overview":"Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.","release_date":"2015-06-09"},{"vote_count":5430,"id":263115,"video":false,"vote_average":7.5,"title":"Logan","popularity":32.155655,"poster_path":"/gGBu0hKw9BGddG8RkRAMX7B6NDB.jpg","original_language":"en","original_title":"Logan","genre_ids":[28,18,878],"backdrop_path":"/5pAGnkFYSsFJ99ZxDIYnhQbQFXs.jpg","adult":false,"overview":"In the near future, a weary Logan cares for an ailing Professor X in a hideout on the Mexican border. But Logan's attempts to hide from the world and his legacy are upended when a young mutant arrives, pursued by dark forces.","release_date":"2017-02-28"},{"vote_count":2047,"id":315837,"video":false,"vote_average":5.9,"title":"Ghost in the Shell","popularity":31.631589,"poster_path":"/myRzRzCxdfUWjkJWgpHHZ1oGkJd.jpg","original_language":"en","original_title":"Ghost in the Shell","genre_ids":[28,80,18,9648,878,53],"backdrop_path":"/dDVqfmCzSy3TKSmiS2pJ9QB5E3P.jpg","adult":false,"overview":"In the near future, Major is the first of her kind: a human saved from a terrible crash, then cyber-enhanced to be a perfect soldier devoted to stopping the world's most dangerous criminals.","release_date":"2017-03-29"},{"vote_count":8993,"id":76341,"video":false,"vote_average":7.2,"title":"Mad Max: Fury Road","popularity":29.879073,"poster_path":"/kqjL17yufvn9OVLyXYpvtyrFfak.jpg","original_language":"en","original_title":"Mad Max: Fury Road","genre_ids":[28,12,878,53],"backdrop_path":"/phszHPFVhPHhMZgo0fWTKBDQsJA.jpg","adult":false,"overview":"An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.","release_date":"2015-05-13"},{"vote_count":13,"id":460790,"video":false,"vote_average":5.8,"title":"Starship Troopers: Traitor of Mars","popularity":28.69347,"poster_path":"/dzqEq8Jbvb5SYGoYPqLyIRrt6Cm.jpg","original_language":"en","original_title":"Starship Troopers: Traitor of Mars","genre_ids":[28,16,878],"backdrop_path":"/u3hiCBwJ2yGCiJb3kOoqXThTQ7Z.jpg","adult":false,"overview":"Federation trooper Johnny Rico is ordered to work with a group of new recruits on a satellite station on Mars, where giant bugs have decided to target their next attack.","release_date":"2017-08-21"},{"vote_count":0,"id":470370,"video":false,"vote_average":0,"title":"Thomas & Friends: Journey Beyond Sodor","popularity":24.078169,"poster_path":"/aQCrw3oeN9zmAu4ynmJwwfLGQUx.jpg","original_language":"en","original_title":"Thomas & Friends: Journey Beyond Sodor","genre_ids":[16],"backdrop_path":"/HBCV6Sicfi8r39L9GiNvHjqznW.jpg","adult":false,"overview":"Join Thomas and his friends in this exciting adventure to the mainland that shows us friendship is more important than being the favorite engine. Can Thomas and the new experimental engines save James and help bring him back to the Island of Sodor?","release_date":"2017-08-22"},{"vote_count":4151,"id":119450,"video":false,"vote_average":7.3,"title":"Dawn of the Planet of the Apes","popularity":23.791588,"poster_path":"/2EUAUIu5lHFlkj5FRryohlH6CRO.jpg","original_language":"en","original_title":"Dawn of the Planet of the Apes","genre_ids":[878,28,18,53],"backdrop_path":"/rjUl3pd1LHVOVfG4IGcyA1cId5l.jpg","adult":false,"overview":"A group of scientists in San Francisco struggle to stay alive in the aftermath of a plague that is wiping out humanity, while Caesar tries to maintain dominance over his community of intelligent apes.","release_date":"2014-06-26"}]
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

    public static class ResultsBean implements Serializable{
        /**
         * vote_count : 4185
         * id : 211672
         * video : false
         * vote_average : 6.4
         * title : Minions
         * popularity : 220.212696
         * poster_path : /q0R4crx2SehcEEQEkYObktdeFy.jpg
         * original_language : en
         * original_title : Minions
         * genre_ids : [10751,16,12,35]
         * backdrop_path : /uX7LXnsC7bZJZjn048UCOwkPXWJ.jpg
         * adult : false
         * overview : Minions Stuart, Kevin and Bob are recruited by Scarlet Overkill, a super-villain who, alongside her inventor husband Herb, hatches a plot to take over the world.
         * release_date : 2015-06-17
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
