package 结构型模式.代理模式;

import 结构型模式.代理模式.downloader.YouTubeDownloader;
import 结构型模式.代理模式.proxy.YouTubeCacheProxy;
import 结构型模式.代理模式.some_cool_media_library.ThirdPartyYouTubeClass;

/**
 * <pre>
 * Description:
 *          代理模式,结构型模式
 *          无需修改客户代码的前提下于已有类的对象上增加额外行为
 *          实现延迟初始化， 并对低效的第三方 YouTube 集成程序库进行缓存。
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class Demo {

    public static void main(String[] args) {

        //原下载器下载
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        //缓存代理类下载
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("缓存代理类节约时间: " + (naive - smart) + "毫秒");
    }

    private static long test(YouTubeDownloader downloader) {

        long startTime = System.currentTimeMillis();
        //第一次下载
        downloader.renderPopularVideos();
        downloader.renderVideoPage("1");
        //第二次下载，用于缓存代理类模拟从缓存从获取视频
        downloader.renderPopularVideos();
        downloader.renderVideoPage("3");
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("下载时间: " + estimatedTime + "毫秒\n");
        return estimatedTime;
    }

}
