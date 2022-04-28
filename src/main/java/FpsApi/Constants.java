package FpsApi;

public class Constants {

    public interface GenericEnum {
        long getId();
    }

    public enum PlayingStatus implements GenericEnum {
        PLAYING, END_MODE;
        @Override
        public long getId() {
            return this.ordinal();
        }
    }
}
