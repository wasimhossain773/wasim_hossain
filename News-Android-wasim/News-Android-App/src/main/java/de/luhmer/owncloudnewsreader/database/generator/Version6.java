package de.luhmer.owncloudnewsreader.database.generator;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class Version6 extends SchemaVersion {

    /**
     * Constructor
     *
     * @param current
     */
    public Version6(boolean current) {
        super(current);

        Schema schema = getSchema();
        addEntitysToSchema(schema);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getVersionNumber() {
        return 6;
    }

    @SuppressWarnings("unused") // id properties (folderId, etc.) need to be in database
    private static void addEntitysToSchema(Schema schema) {

        /* Folder */
        Entity folder = schema.addEntity("Folder");
        Property folderId = folder.addIdProperty().notNull().getProperty();
        folder.addStringProperty("label").notNull();

        /* Feed */
        Entity feed = schema.addEntity("Feed");
        Property feedId = feed.addIdProperty().notNull().getProperty();
        Property folderIdProperty = feed.addLongProperty("folderId").index().getProperty();

        feed.addStringProperty("feedTitle").notNull();
        feed.addStringProperty("faviconUrl");
        feed.addStringProperty("link");
        feed.addStringProperty("avgColour");



        /* RSS Item */
        Entity rssItem = schema.addEntity("RssItem");
        Property rssItemId = rssItem.addIdProperty().notNull().getProperty();
        Property rssItemFeedId = rssItem.addLongProperty("feedId").notNull().index().getProperty();

        rssItem.addStringProperty("link");
        rssItem.addStringProperty("title");
        rssItem.addStringProperty("body");
        rssItem.addBooleanProperty("read");
        rssItem.addBooleanProperty("starred");
        rssItem.addStringProperty("author").notNull();
        rssItem.addStringProperty("guid").notNull();
        rssItem.addStringProperty("guidHash").notNull();
        rssItem.addStringProperty("fingerprint").notNull();
        rssItem.addBooleanProperty("read_temp");
        rssItem.addBooleanProperty("starred_temp");
        rssItem.addDateProperty("lastModified");
        rssItem.addDateProperty("pubDate");


        rssItem.addStringProperty("enclosureLink");
        rssItem.addStringProperty("enclosureMime");


        feed.addToOne(folder, folderIdProperty);
        folder.addToMany(feed, folderIdProperty);

        feed.addToMany(rssItem, rssItemFeedId);
        rssItem.addToOne(feed, rssItemFeedId);




        Entity rssItemView = schema.addEntity("CurrentRssItemView");
        rssItemView.addIdProperty().notNull();
        rssItemView.addLongProperty("rssItemId").notNull();


        rssItem.implementsInterface("HasId<Long>");
    }
}
