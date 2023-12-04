# Confluence content properties to CQL
This plugin adds content properties to CQL indexing.

The plugin already has a property called `amoCrmLead`, it is preset, since this plugin is recommended for use with the [amocrm-jira-confluence](/../../../amocrm-jira-confluence) integration module.

## Usage

An example of using added properties to the CQL index through this plugin using a preset field as an example:
```
content.property[amoCrmLead].id = 12345678
```
A plugin ready for installation with a preset property, assembled in "jar" format, is located in the "target" folder: [cql-properties-1.0.0-SNAPSHOT.jar](/../../raw/main/target/cql-properties-1.0.0-SNAPSHOT.jar)

## Adding Properties to a Plugin

To add a new property to the plugin, you need to add the following lines to the `src/main/resources/atlassian-plugin.xml` file, inside the `<atlassian-plugin>` element: 
```
<content-property-index-schema key="yourProperty-key">
    <key property-key="yourProperty">
        <extract path="elementKeyOfYourProperty" type="string" />
    </key>
</content-property-index-schema>
```
**where:**
- `yourProperty` - your property to adding (example: "amoCrmLead").
- `elementKeyOfYourProperty` - path to element key for value of your property (example: "id" or "info.name"). In this case, the array with data to fill the element's value will look like this:
  ```
  [ key: 'amoCrmLead', value: [ id: '12345678' ] ]
  ```
  or:
  ```
  [ key: 'amoCrmLead', value: [ info: [ id: '12345678', name: 'amoCRM Lead' ] ] ]
  ```
- `type="string"` - "string" is an example of an element's data type (can be of 4 types: string, text, number, date)

**Example of a preset property from code:**
```
<content-property-index-schema key="amoCrmLead-key">
    <key property-key="amoCrmLead">
        <extract path="id" type="string" />
    </key>
</content-property-index-schema>
```
## Requirements for editing and building the plugin
1. [JDK](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html) (Java SE Development Kit **8u251**)
2. [Atlassian SDK](https://developer.atlassian.com/server/framework/atlassian-sdk/install-the-atlassian-sdk-on-a-linux-or-mac-system/)

## Editing and building
1. Clone this repository.
2. Editing the file `src/main/resources/atlassian-plugin.xml` ([Adding your properties](#adding-properties-to-a-plugin)).
3. From the command promt, go to the root folder of the plugin and run the command: `atlas-mvn package`.
4. The updated package is here: `target/cql-properties-1.0.0-SNAPSHOT.jar`
