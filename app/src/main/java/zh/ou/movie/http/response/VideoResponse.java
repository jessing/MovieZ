package zh.ou.movie.http.response;

import java.util.List;

/**
 * author:   zhoux
 * date:    2017/8/28
 * email:   13617694689@163.com
 */

public class VideoResponse {

    /**
     * id : 281338
     * results : [{"id":"5970c4b69251412d41039c53","iso_639_1":"en","iso_3166_1":"US","key":"yDBFrQvfGlQ","name":"Catch Up Before the End","site":"YouTube","size":1080,"type":"Featurette"},{"id":"58ba5a1cc3a3686630017615","iso_639_1":"en","iso_3166_1":"US","key":"UEP1Mk6Un98","name":"Official Teaser Trailer","site":"YouTube","size":1080,"type":"Teaser"},{"id":"58de6f329251411b7a00d6a4","iso_639_1":"en","iso_3166_1":"US","key":"JDcAlo8i2y8","name":"Official Trailer #2","site":"YouTube","size":1080,"type":"Trailer"},{"id":"591c0c619251414ab1007230","iso_639_1":"en","iso_3166_1":"US","key":"qxjPjPzQ1iU","name":"Final Trailer","site":"YouTube","size":1080,"type":"Trailer"},{"id":"591c0c8bc3a368723d007bd2","iso_639_1":"en","iso_3166_1":"US","key":"dgxBI_X1vGY","name":"\"All of Human History Has Led to This Moment\" TV Commercial","site":"YouTube","size":1080,"type":"Clip"},{"id":"5970c467c3a3687fc70360fc","iso_639_1":"en","iso_3166_1":"US","key":"wWNk3COVNS4","name":"Legacy","site":"YouTube","size":1080,"type":"Featurette"},{"id":"5970c4f59251417fef0009ae","iso_639_1":"en","iso_3166_1":"US","key":"X6x-QSinrUU","name":"Meeting Bad Ape","site":"YouTube","size":1080,"type":"Clip"},{"id":"5970c5819251412d4c038d3b","iso_639_1":"en","iso_3166_1":"US","key":"h5XQq1ulspc","name":"Making History","site":"YouTube","size":1080,"type":"Featurette"},{"id":"5970c6109251412d4c038db9","iso_639_1":"en","iso_3166_1":"US","key":"FCy9A-nfj24","name":"Bad Ape and Maurice","site":"YouTube","size":1080,"type":"Clip"},{"id":"5970c62b9251415e8601fc47","iso_639_1":"en","iso_3166_1":"US","key":"vm7vE9ujNYs","name":"Meeting Nova","site":"YouTube","size":1080,"type":"Clip"},{"id":"5970c6ab9251417f9d000b73","iso_639_1":"en","iso_3166_1":"US","key":"ThXG-Kq-RkQ","name":"\"I Came For You\"","site":"YouTube","size":1080,"type":"Clip"},{"id":"5970c6f6c3a3687fc7036312","iso_639_1":"en","iso_3166_1":"US","key":"NeZ8BQBl8NA","name":"Face Of Caesar","site":"YouTube","size":1080,"type":"Featurette"},{"id":"5970c72dc3a368551d000b24","iso_639_1":"en","iso_3166_1":"US","key":"f_Q-R2gICco","name":"A Hero Becomes Legend","site":"YouTube","size":1080,"type":"Clip"},{"id":"5970c88bc3a36815930035a0","iso_639_1":"en","iso_3166_1":"US","key":"hHUBpMznFJI","name":"Official Trailer #1","site":"YouTube","size":1080,"type":"Trailer"},{"id":"5970c8cec3a3686fc7022228","iso_639_1":"en","iso_3166_1":"US","key":"1TxqmlIv1Iw","name":"Official HD Trailer #3","site":"YouTube","size":1080,"type":"Trailer"}]
     */

    private int id;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * id : 5970c4b69251412d41039c53
         * iso_639_1 : en
         * iso_3166_1 : US
         * key : yDBFrQvfGlQ
         * name : Catch Up Before the End
         * site : YouTube
         * size : 1080
         * type : Featurette
         */

        private String id;
        private String iso_639_1;
        private String iso_3166_1;
        private String key;
        private String name;
        private String site;
        private int size;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public String getIso_3166_1() {
            return iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
