package 结构型模式.代理模式.some_cool_media_library;

import java.util.HashMap;

/**
 * <pre>
 * Description:
 *          远程服务实现
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    /**
     * @Description:
     *          模拟获取YouTube流行视频
     * @Author Zepp Deng [2021-01-08 14:26]
     * @Return HashMap<String, Video>
     */
    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    /**
     * @Description:
     *          模拟获取YouTube指定视频
     * @Author Zepp Deng [2021-01-08 14:27]
     * @param videoId
     */
    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    /**
     * @Description:
     *          模拟连接服务
     * @Author Zepp Deng [2021-01-08 14:18]
     * @param server
     */
    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.print("Connected!" + "\n");
    }

    /**
     * @Description:
     *         模拟下载流行视频
     * @Author Zepp Deng [2021-01-08 14:22]
     * @Return HashMap<String, Video>
     */
    private HashMap<String, Video> getRandomVideos() {
        System.out.print("下载流行视频开始");

        experienceNetworkLatency();
        HashMap<String, Video> hmap = new HashMap<>();
        hmap.put("1", new Video("1", "1.avi"));
        hmap.put("2", new Video("2", "2.mp4"));
        hmap.put("3", new Video("3", "3.mpq"));
        hmap.put("4", new Video("4", "4.mov"));
        hmap.put("5", new Video("5", "5.avi"));

        System.out.print("下载流行视频完成" + "\n");
        return hmap;
    }

    /**
     * @Description:
     *          模拟下载指定视频
     * @Author Zepp Deng [2021-01-08 14:31]
     * @param videoId
     * @Return Video
     */
    private Video getSomeVideo(String videoId) {
        System.out.print("下载指定视频");

        experienceNetworkLatency();
        Video video = new Video(videoId, "Some video title");

        System.out.print("下载指定视频完成" + "\n");
        return video;
    }

    /**
     * @Description:
     *          实现延迟初始化,模拟视频下载时间
     * @Author Zepp Deng [2021-01-08 14:21]
     */
    private void experienceNetworkLatency(){
        //随机等待时间
        int randomLatency = random(5,10);
        for (int i=0; i<randomLatency; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
