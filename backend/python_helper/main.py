import creator.entity
import path_finder
from creator import create_for_entity
from creator.entity import Entity
from creator.entity import Types


def main():
    path_to_src = path_finder.find_src()
    entity = Entity.EntityBuilder().set_name("Experience").\
        set_property(Types.Date, "date").\
        set_property(Types.String, "title").\
        set_property(Types.String, "description").\
        build()

    creator.create_for_entity(path_to_src,entity)

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

