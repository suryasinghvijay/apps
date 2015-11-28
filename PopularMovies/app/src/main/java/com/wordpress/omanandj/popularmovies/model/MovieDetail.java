package com.wordpress.omanandj.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by ojha on 28/11/15.
 */
public class MovieDetail implements Parcelable
{
    private String id;
    private String originalTitle;
    private String posterPath;
    private String overview;
    private Date releaseDate;
    private String voteAverage;
    private int runtime;

    public MovieDetail(String id, String originalTitle, String posterPath, String overview, Date releaseDate, String voteAverage,
                       int runtime)
    {
        this.id = id;
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.runtime = runtime;
    }

    public String getId()
    {
        return id;
    }

    public String getOriginalTitle()
    {
        return originalTitle;
    }

    public String getPosterPath()
    {
        return posterPath;
    }

    public String getOverview()
    {
        return overview;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public String getVoteAverage()
    {
        return voteAverage;
    }

    public int getRuntime()
    {
        return runtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDetail movieDetail = (MovieDetail) o;

        if (runtime != movieDetail.runtime) return false;
        if (!id.equals(movieDetail.id)) return false;
        if (!originalTitle.equals(movieDetail.originalTitle)) return false;
        if (!posterPath.equals(movieDetail.posterPath)) return false;
        return releaseDate.equals(movieDetail.releaseDate);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + originalTitle.hashCode();
        result = 31 * result + posterPath.hashCode();
        result = 31 * result + releaseDate.hashCode();
        result = 31 * result + runtime;
        return result;
    }

    protected MovieDetail(Parcel in)
    {
        id = in.readString();
        originalTitle = in.readString();
        posterPath = in.readString();
        overview = in.readString();
        releaseDate = new Date(in.readLong());
        voteAverage = in.readString();
        runtime = in.readInt();
    }

    public static final Creator<MovieDetail> CREATOR = new Creator<MovieDetail>() {
        @Override
        public MovieDetail createFromParcel(Parcel in)
        {
            return new MovieDetail(in);
        }

        @Override
        public MovieDetail[] newArray(int size)
        {
            return new MovieDetail[size];
        }
    };

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(id);
        dest.writeString(originalTitle);
        dest.writeString(posterPath);
        dest.writeString(overview);
        dest.writeLong(releaseDate.getTime());
        dest.writeString(voteAverage);
        dest.writeInt(runtime);
    }
}