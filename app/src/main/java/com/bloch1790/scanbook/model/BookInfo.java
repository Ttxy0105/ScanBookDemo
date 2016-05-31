package com.bloch1790.scanbook.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class BookInfo implements Parcelable {


    /**
     * max : 10
     * numRaters : 935
     * average : 9.1
     * min : 0
     */

    private RatingEntity rating;
    /**
     * rating : {"max":10,"numRaters":935,"average":"9.1","min":0}
     * subtitle :
     * author : ["Joshua Bloch"]
     * pubdate : 2009-1-1
     * tags : [{"count":853,"name":"java","title":"java"},{"count":384,"name":"编程","title":"编程"},{"count":373,"name":"Java","title":"Java"},{"count":272,"name":"effective","title":"effective"},{"count":181,"name":"程序设计","title":"程序设计"},{"count":173,"name":"计算机","title":"计算机"},{"count":148,"name":"经典","title":"经典"},{"count":104,"name":"软件开发","title":"软件开发"}]
     * origin_title : Effective Java Second Edition
     * image : https://img1.doubanio.com/mpic/s3479802.jpg
     * binding : 平装
     * translator : ["俞黎敏"]
     * catalog : 译者序
     * 序
     * 前言
     * 致谢
     * 第1章 引言
     * 第2章 创建和销毁对象
     * 第1条：考虑用静态工厂方法代替构造器
     * 第2条：遇到多个构造器参数时要考虑用构建器
     * 第3条：用私有构造器或者枚举类型强化Singleton属性
     * 第4条：通过私有构造器强化不可实例化的能力
     * 第5条：避免创建不必要的对象
     * 第6条：消除过期的对象引用
     * 第7条：避免使用终结方法
     * 第3章 对于所有对象都通用的方法
     * 第8条：覆盖equals时请遵守通用约定
     * 第9条：覆盖equals时总要覆盖hashCode
     * 第10条：始终要覆盖toString
     * 第11条：谨慎地覆盖clone
     * 第12条：考虑实现Comparable接口
     * 第4章 类和接口
     * 第13条：使类和成员的可访问性最小化
     * 第14条：在公有类中使用访问方法而非公有域
     * 第15条：使可变性最小化
     * 第16条：复合优先于继承
     * 第17条：要么为继承而设计，并提供文档说明，要么就禁止继承
     * 第18条：接口优于抽象类
     * 第19条：接口只用于定义类型
     * 第20条：类层次优于标签类
     * 第21条：用函数对象表示策略
     * 第22条：优先考虑静态成员类
     * 第5章 泛型
     * 第23条：请不要在新代码中使用原生态类型
     * 第24条：消除非受检警告
     * 第25条：列表优先于数组
     * 第26条：优先考虑泛型
     * 第27条：优先考虑泛型方法
     * 第28条：利用有限制通配符来提升API的灵活性
     * 第29条：优先考虑类型安全的异构容器
     * 第6章 枚举和注解
     * 第30条：用enum代替int常量
     * 第31条：用实例域代替序数
     * 第32条：用EnumSet代替位域
     * 第33条：用EnumMap代替序数索引
     * 第34条：用接口模拟可伸缩的枚举
     * 第35条：注解优先于命名模式
     * 第36条：坚持使用Override注解
     * 第37条：用标记接口定义类型
     * 第7章 方法
     * 第38条：检查参数的有效性
     * 第39条：必要时进行保护性拷贝
     * 第40条：谨慎设计方法签名
     * 第41条：慎用重载
     * 第42条：慎用可变参数
     * 第43条：返回零长度的数组或者集合，而不是：null
     * 第44条：为所有导出的API元素编写文档注释
     * 第8章 通用程序设计
     * 第45条：将局部变量的作用域最小化
     * 第46条：for-each循环优先于传统的for循环
     * 第47条：了解和使用类库
     * 第48条：如果需要精确的答案，请避免使用float和double
     * 第49条：基本类型优先于装箱基本类型
     * 第50条：如果其他类型更适合，则尽量避免使用字符串
     * 第51条：当心字符串连接的性能
     * 第52条：通过接口引用对象
     * 第53条：接口优先于反射机制
     * 第54条：谨慎地使用本地方法
     * 第55条：谨慎地进行优化
     * 第56条：遵守普遍接受的命名惯例
     * 第9章 异常
     * 第57条：只针对异常的情况才使用异常
     * 第58条：对可恢复的情况使用受检异常，对编程错误使用运行时异常
     * 第59条：避免不必要地使用受检的异常
     * 第60条：优先使用标准的异常
     * 第61条：抛出与抽象相对应的异常
     * 第62条：每个方法抛出的异常都要有文档
     * 第63条：在细节消息中包含能捕获失败的信息
     * 第64条：努力使失败保持原子性
     * 第65条：不要忽略异常
     * 第10章 并发
     * 第66条：同步访问共享的可变数据
     * 第67条：避免过度同步
     * 第68条：executor和task优先干线程
     * 第69条：并发工具优先于wait和notify
     * 第70条：线程安全性的文档化
     * 第71条：慎用延迟初始化
     * 第72条：不要依赖于线程调度器
     * 第73条：避免使用线程组
     * 第11章 序列化
     * 第74条：谨慎地实现Serializable接口
     * 第75条：考虑使用自定义的序列化形式
     * 第76条：保护性地编写readObject方法
     * 第77条：对于实例控制，枚举类型优先于readResolve
     * 第78条：考虑用序列化代理代替序列化实例
     * 附录 第1版与第2版条目对照
     * 中英文术语对照
     * 参考文献
     * pages : 287
     * images : {"small":"https://img1.doubanio.com/spic/s3479802.jpg","large":"https://img1.doubanio.com/lpic/s3479802.jpg","medium":"https://img1.doubanio.com/mpic/s3479802.jpg"}
     * alt : http://book.douban.com/subject/3360807/
     * id : 3360807
     * publisher : 机械工业出版社
     * isbn10 : 7111255836
     * isbn13 : 9787111255833
     * title : Effective java 中文版（第2版）
     * url : http://api.douban.com/v2/book/3360807
     * alt_title : Effective Java Second Edition
     * author_intro : Joshua Bloch是Google公司的首席Java架构师。是Jolt大奖的获得者。他曾是Sun公司的杰出工程师，和Transarc公司的高级系统设计师。Bloch曾带领团队设计和实现过无数的Java平台特性，包括JDK 5.0语言增强版和获奖的Java Collections Framework。他的著作还包括：《Java Puzzlers》、《Java Concurrency in Practive》等。
     * summary : 本书介绍了在Java编程中78条极具实用价值的经验规则，这些经验规则涵盖了大多数开发人员每天所面临的问题的解决方案。通过对Java平台设计专家所使用的技术的全面描述，揭示了应该做什么，不应该做什么才能产生清晰、健壮和高效的代码。
     * 本书中的每条规则都以简短、独立的小文章形式出现，并通过例子代码加以进一步说明。本书内容全面，结构清晰，讲解详细。可作为技术人员的参考用书。
     * series : {"id":"28333","title":"Sun公司核心技术丛书"}
     * price : 52.00元
     */

    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String pages;
    /**
     * small : https://img1.doubanio.com/spic/s3479802.jpg
     * large : https://img1.doubanio.com/lpic/s3479802.jpg
     * medium : https://img1.doubanio.com/mpic/s3479802.jpg
     */

    private ImagesEntity images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    /**
     * id : 28333
     * title : Sun公司核心技术丛书
     */

    private SeriesEntity series;
    private String price;
    private List<String> author;
    /**
     * count : 853
     * name : java
     * title : java
     */

    private List<TagsEntity> tags;
    private List<String> translator;

    public RatingEntity getRating() {
        return rating;
    }

    public void setRating(RatingEntity rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesEntity getImages() {
        return images;
    }

    public void setImages(ImagesEntity images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public SeriesEntity getSeries() {
        return series;
    }

    public void setSeries(SeriesEntity series) {
        this.series = series;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagsEntity> tags) {
        this.tags = tags;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.rating, flags);
        dest.writeString(this.subtitle);
        dest.writeString(this.pubdate);
        dest.writeString(this.origin_title);
        dest.writeString(this.image);
        dest.writeString(this.binding);
        dest.writeString(this.catalog);
        dest.writeString(this.pages);
        dest.writeParcelable(this.images, flags);
        dest.writeString(this.alt);
        dest.writeString(this.id);
        dest.writeString(this.publisher);
        dest.writeString(this.isbn10);
        dest.writeString(this.isbn13);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.alt_title);
        dest.writeString(this.author_intro);
        dest.writeString(this.summary);
        dest.writeParcelable(this.series, flags);
        dest.writeString(this.price);
        dest.writeStringList(this.author);
        dest.writeTypedList(tags);
        dest.writeStringList(this.translator);
    }

    public BookInfo() {
    }

    protected BookInfo(Parcel in) {
        this.rating = in.readParcelable(RatingEntity.class.getClassLoader());
        this.subtitle = in.readString();
        this.pubdate = in.readString();
        this.origin_title = in.readString();
        this.image = in.readString();
        this.binding = in.readString();
        this.catalog = in.readString();
        this.pages = in.readString();
        this.images = in.readParcelable(ImagesEntity.class.getClassLoader());
        this.alt = in.readString();
        this.id = in.readString();
        this.publisher = in.readString();
        this.isbn10 = in.readString();
        this.isbn13 = in.readString();
        this.title = in.readString();
        this.url = in.readString();
        this.alt_title = in.readString();
        this.author_intro = in.readString();
        this.summary = in.readString();
        this.series = in.readParcelable(SeriesEntity.class.getClassLoader());
        this.price = in.readString();
        this.author = in.createStringArrayList();
        this.tags = in.createTypedArrayList(TagsEntity.CREATOR);
        this.translator = in.createStringArrayList();
    }

    public static final Parcelable.Creator<BookInfo> CREATOR = new Parcelable.Creator<BookInfo>() {
        @Override
        public BookInfo createFromParcel(Parcel source) {
            return new BookInfo(source);
        }

        @Override
        public BookInfo[] newArray(int size) {
            return new BookInfo[size];
        }
    };

}
