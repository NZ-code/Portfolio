from enum import Enum
class Types(Enum):
    String = "String"
    Double = "Double"
    Integer = "Integer"
    Date = "Date"
class Entity:
    def __init__(self):
        self.name = ""
        self.fields = []
    def add_field(self, type, name):
        self.fields.append((type.value, name))
    def __str__(self):
        return f" entity {self.name} " \
               f"fields:" \
               f"{self.fields}"
    class EntityBuilder:
        def __init__(self):
           self._entity = Entity()
        def set_name(self, name):
            self._entity.name = name
            return self
        def set_property(self, type , name ):
            self._entity.add_field(type, name)
            return self
        def build(self):
            return self._entity
