<template>
  <header>
  <div>
    <div>
      <h1>Kontaktid</h1>
      <form @submit.prevent="fetchContacts">
        <input type="text" id="name" v-model="name"/>
        <button type="submit">Otsi</button>
        <button @click="addContact">Lisa kontakt</button>
      </form>
        <table class="table table-dark">
          <thead>
          <tr>
            <th>Nimi <button class="sort-button" @click="sortByName"><img id="pic" src="../resources/sort.png" alt="sort"></button></th>
            <th>Koodnimi</th>
            <th>Telefoninumber</th>
            <th></th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="contact in contacts" :key="contact.id">
            <td>{{ contact.name }}</td>
            <td>{{ contact.codeName }}</td>
            <td>{{ contact.phoneNumber }}</td>
            <td><button id="delete_button" @click="deleteContact(contact.id)">X</button></td>
          </tr>
          </tbody>
        </table>
  </div>
  </div>
  </header>
</template>

<script>
import axios from 'axios';

export default {
  name: 'ContactsTable',
  data() {
    return {
      name: '',
      sort_direction: false,
      all: true,
      contacts: []
    };
  },
  beforeMount() {
    this.fetchAllContacts();
  },

  methods: {
    async addContact() {
      const name = prompt("Sisesta nimi");
      const codeName = prompt("Sisesta koodnimi");
      const phoneNumber = prompt("Sisesta telefoninumber");
      if (this.contacts.some(contact => contact.name === name || contact.codeName === codeName)) {
        alert("Kontakt juba eksisteerib");
        return;
      }
      try {
        await axios.post('http://localhost:8080/contact', {
          name: name,
          codeName: codeName,
          phoneNumber: phoneNumber
        });
      } catch (error) {
        console.error(error);
      }
      await this.fetchAllContacts();
    },
    async deleteContact(id) {
      if (!confirm("Kas oled kindel, et soovid kontakti kustutada?")) {
        return;
      }
      console.log(id);
      try {
        await axios.delete('http://localhost:8080/contact/id',
        {
          params: {
            id: id
          }
        });
      } catch (error) {
        console.error(error);
      }
      await this.fetchAllContacts();
    },
    sortByName() {
      if (this.sort_direction) {
        this.contacts.sort((a, b) => {
          this.sort_direction = false;
          return a.name.localeCompare(b.name);
        });
      } else {
        this.contacts.sort((a, b) => {
          this.sort_direction = true;
          return b.name.localeCompare(a.name);
        });
      }

    },
    async fetchAllContacts() {
      try {
        const response = await axios.get('http://localhost:8080/contact/name', {
          params: {
            name: "",
            all: this.all

          }
        });
        this.contacts = response.data;
      } catch (error) {
        console.error(error);
      }
    },
    async fetchContacts() {
      try {
        const response = await axios.get('http://localhost:8080/contact/name', {
          params: {
            name: this.name,
            all: false
          }
        });
        this.contacts = response.data;
      } catch (error) {
        console.error(error);
      }
    }
  }
};
</script>

<style scoped>

.table {
  width: 100%;
  margin-bottom: 1rem;
  border-collapse: collapse;
  background-color: #343a40;
  color: #fff;
  border: 1px solid #dee2e6;

}
#pic {
  width: 20px;
  height: 20px;
}
.sort-button {
  background-color: #343a40;
  border: none;
  color: #fff;
  padding-left: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  padding-top: 3px;
}

#delete_button {
  background-color: firebrick;
  border: none;
  color: #fff;
  margin-left: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
</style>